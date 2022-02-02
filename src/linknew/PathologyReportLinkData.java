package se.cambiosys.client.ros.common.link;

import se.cambiosys.client.ros.common.link.context.LinkContext;
import se.cambiosys.client.ros.common.util.service.OMServiceInterface;

/**
 * Contains shareable pathology report link related module reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 28, 2021
 */
public class PathologyReportLinkData extends ReportLinkData
{
  public PathologyReportLinkData(LinkContext context)
  {
    super(context);
  }

  @Override
  public String getService()
  {
    return OMServiceInterface.SERVICE_OPEN_PATHOLOGY_LAB_LIST_FOR_MESSAGE;
  }
  
  @Override
  public String[] getArguments()
  {
    return new String[] {context.getReportId()};
  }
}
