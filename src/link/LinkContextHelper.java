package se.cambiosys.client.ros.common.link.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import se.cambiosys.client.framework.core.ClientException;
import se.cambiosys.client.ros.common.data.entity.ClientInboxItem;
import se.cambiosys.client.ros.common.data.entity.ClientResult;
import se.cambiosys.client.ros.common.gui.toolkit.LanguageToolkit;
import se.cambiosys.client.ros.common.util.toolkit.RoSConstants;

/**
 * Generate context data{@link LinkContext} 
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public final class LinkContextHelper
{

  private LinkContextHelper()
  {

  }

  /**
   * Generate link context using ClientInboxItem 
   * @return {@link LinkContext} 
   * @throws ClientException 
   */

  public static LinkContext buildLinkContext(ClientInboxItem inboxItem) throws ClientException
  {
    if (!isValidInboxItem(inboxItem))
    {
      throwsClientException();
    }
    if (inboxItem.getSpecialityNumber() == RoSConstants.SPECIALITY_PATHOLOGY_CYTOLOGY)
    {
      return buildPathologyReportLinkContext(inboxItem);
    }
    return buildNonPathologyReportLinkContext(inboxItem);
  }

  /**
   * Generate link context using ClientResult 
   * Not supported for pathology hence report id is not available with results use {@link #buildLinkContext(ClientInboxItem inboxItem)} 
   * @return {@link LinkContext} 
   * @throws ClientException 
   */
  public static LinkContext buildLinkContext(List<ClientResult> clientResults) throws ClientException
  {
    if (!isValidResults(clientResults))
    {
      throwsClientException();
    }
    int specialityNumber = clientResults.get(0).getSpeciality();
    if (specialityNumber == RoSConstants.SPECIALITY_CHEMISTRY
        || specialityNumber == RoSConstants.SPECIALITY_LOCAL_ANALYSES)
    {
      return buildResultLinkContext(clientResults);
    }
    return buildReportLinkContextWitRequestId(clientResults.get(0));
  }

  private static LinkContext buildResultLinkContext(List<ClientResult> clientResults) throws ClientException
  {
    if (!isValidResultIds(clientResults))
    {
      throwsClientException();
    }
    return new LinkContext.LinkContextBuilder(LinkContextType.RESULT, clientResults.get(0).getSpeciality())
        .resultIds(getResultIds(clientResults)).timeStamp(getTimeStamp(clientResults)).build();
  }

  private static LinkContext buildPathologyReportLinkContext(ClientInboxItem inboxItem) throws ClientException
  {
    ClientResult clientResult = inboxItem.getPathologyClientResult();
    List<ClientResult> clientResults = clientResult != null ? Arrays.asList(clientResult) : null;
    if (!isValidResults(clientResults))
    {
      throwsClientException();
    }
    return buildReportLinkContextWitReportId(inboxItem, clientResult);
  }

  private static LinkContext buildNonPathologyReportLinkContext(ClientInboxItem inboxItem) throws ClientException
  {
    List<ClientResult> clientResults = inboxItem.getResults() != null ? Arrays.asList(inboxItem.getResults())
        : new ArrayList<>();
    if (!isValidResults(clientResults))
    {
      throwsClientException();
    }
    return buildReportLinkContextWitRequestId(clientResults.get(0));
  }

  private static LinkContext buildReportLinkContextWitRequestId(ClientResult result) throws ClientException
  {
    if (!isValidRequestId(result))
    {
      throwsClientException();
    }
    return new LinkContext.LinkContextBuilder(LinkContextType.REPORT, result.getSpeciality())
        .requestId(result.getRequestID()).timeStamp(getTimeStamp(result)).build();
  }

  private static LinkContext buildReportLinkContextWitReportId(ClientInboxItem inboxItem, ClientResult clientResult)
  {
    return new LinkContext.LinkContextBuilder(LinkContextType.REPORT, inboxItem.getSpecialityNumber())
        .reportId(inboxItem.getReportId()).timeStamp(getTimeStamp(clientResult)).build();
  }

  private static boolean isValidInboxItem(ClientInboxItem inboxItem)
  {
    if (inboxItem != null && inboxItem.getSpecialityNumber() == RoSConstants.SPECIALITY_PATHOLOGY_CYTOLOGY) // Pathology not populated InboxItemData properly. 
    {
      return inboxItem.getVersionedId() != null;
    }
    return inboxItem != null && inboxItem.getData() != null && inboxItem.isValid();
  }

  private static boolean isValidResults(List<ClientResult> clientResults)
  {
    return clientResults != null && !clientResults.isEmpty();
  }

  private static boolean isValidResultIds(List<ClientResult> clientResults)
  {
    return getResultIds(clientResults) != null && !getResultIds(clientResults).isEmpty();
  }

  private static boolean isValidRequestId(ClientResult result)
  {
    return isValidId(result.getRequestID());
  }
  
  private static boolean isValidId(String id)
  {
    return id != null && !id.isEmpty();
  }

  private static String getTimeStamp(List<ClientResult> clientResults)
  {
    return getTimeStamp(clientResults.get(0));
  }

  public static String getTimeStamp(ClientResult result)
  {
    String resultTestTime = result.getTestTimeActual();
    return LinkUtils.getSuffixDateString(resultTestTime);
  }

  private static List<String> getResultIds(List<ClientResult> clientResults)
  {
    return clientResults.stream().map(ClientResult::getID).filter(id -> !id.isEmpty()).collect(Collectors.toList());
  }

  private static void throwsClientException() throws ClientException
  {
    throw new ClientException(LanguageToolkit.language("Core.Titles.MessageBoxHeading.rf"),
        LanguageToolkit.language("CorruptedReport.rr"));
  }
}
