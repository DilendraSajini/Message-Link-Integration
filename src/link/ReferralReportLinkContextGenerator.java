package link;

/**
 * Generate referral report specific context data{@link LinkContext} 
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 29, 2021
 */
//public class ReferralReportLinkContextGenerator extends ReportLinkContextGenerator
//{
//  public ReferralReportLinkContextGenerator(ReferralClientInboxItem inboxItem)
//  {
//    super(inboxItem);
//  }
//
//  @Override
//  protected String[] getArguments()
//  {
//    ReferralClientInboxItem referralClientInboxItem = (ReferralClientInboxItem) inboxItem;
//    if(referralClientInboxItem.getAttestable() != null) {
//      String attestableTypeName = referralClientInboxItem.getAttestable().getType().name();
//      String id = referralClientInboxItem.isRequestRejected() ? referralClientInboxItem.getRequestId()
//          : referralClientInboxItem.getAttestable().getId();
//      String paientId = referralClientInboxItem.getAttestable().getPatient();
//      return new String[] { attestableTypeName, id, paientId };
//    }
//    return new String[] {};
//  }
//  
//  @Override
//  protected String getResourceString()
//  {
//    if (isRejectedReferral())
//    {
//      return ReferenceArguments.MESSAGE_LINK_TEXT_REFERRAL;
//    }
//    return ReferenceArguments.MESSAGE_LINK_TEXT_ANSWER;
//  }
//
//  private boolean isRejectedReferral()
//  {
//    if (inboxItem != null && inboxItem.getVersionedId() != null
//        && ((ReferralClientInboxItem) inboxItem).getAttestable() != null)
//    {
//      return ((ReferralClientInboxItem) inboxItem).isRequestRejected();
//    }
//    return false;
//  }
//}