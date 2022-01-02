//package link;
//
//import se.cambiosys.client.ros.common.data.entity.ClientInboxItem;
//import se.cambiosys.client.ros.common.data.entity.ClientRequest;
//import se.cambiosys.client.ros.common.data.entity.ReferralClientInboxItem;
//import se.cambiosys.client.ros.common.gui.toolkit.LanguageToolkit;
//import se.cambiosys.client.ros.common.util.toolkit.RoSConstants;
//import se.cambiosys.client.ros.inbox.common.data.dataprovider.OMInboxDataProvider;
//import se.cambiosys.client.ros.inbox.common.data.dataprovider.OMInboxItemDataService;
//
/**
 * Generate report specific context data{@link LinkContext} 
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
//public class ReportLinkContextGenerator implements LinkContextGenerator
//{
//
//  protected ClientInboxItem inboxItem;
//
//  private OMInboxItemDataService omInboxDataProvider;
//
//  public ReportLinkContextGenerator(ClientInboxItem inboxItem)
//  {
//    this.inboxItem = inboxItem;
//    this.omInboxDataProvider = OMInboxDataProvider.getInstance();
//  }
//
//  /**
//   * Generate link context
//   * @return {@link LinkContext} 
//   */
//  public LinkContext generate()
//  {
//    LinkContext linkContext = new LinkContext();
//    if (inboxItem != null && inboxItem.getVersionedId() != null)
//    {
//      linkContext.setType(LinkContextType.REPORT);
//      linkContext.setSpeciality(inboxItem.getSpecialityNumber());
//      linkContext.setArguments(getArguments());
//      linkContext.setResourceString(getResourceString());
//    }
//    return linkContext;
//  }
//
//  /**
//   * Argument id list to opening the reference.
//   * @return String[] 
//   */
//  protected String[] getArguments()
//  {
//    if (inboxItem != null && inboxItem.getResults() != null && inboxItem.getNumberOfResults() > 0)
//    {
//      ClientRequest request = omInboxDataProvider.getRequest(inboxItem.getResultItem(0).getRequestID());
//      return new String[] { request.getID() };
//    }
//    return new String[] {};
//  }
//
//  /**
//   * Resource string value specific to bundle.
//   * Use to generate ReferenceName in link data {@link LinkData}.
//   * @return String
//   */
//  protected String getResourceString()
//  {
//    String resourceString = LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
//        .getResourceString("NewMessageReferece.rr");
//    if (inboxItem != null && inboxItem.getResults() != null && inboxItem.getNumberOfResults() > 0)
//    {
//      String resultTestTime = inboxItem.getResultItem(0).getTestTimeActual();
//      return resourceString + LinkUtils.getSuffixDateString(resultTestTime);
//    }
//    return resourceString;
//  }
//}
