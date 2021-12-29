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
///**
// * @author Dilendra Sajini
// *
// * @since Dec 23, 2021
// */
//public class ReportLinkContextGenerator implements LinkContextGenerator<ClientInboxItem> {
//
//	private ClientInboxItem inboxItem;
//
//	private OMInboxItemDataService omInboxDataProvider;
//
//	public ReportLinkContextGenerator(ClientInboxItem inboxItem) {
//		this.inboxItem = inboxItem;
//		this.omInboxDataProvider = OMInboxDataProvider.getInstance();
//	}
//
//	public LinkContext generate() {
//		LinkContext linkContext = new LinkContext();
//		if (inboxItem != null) {
//			linkContext.setType(LinkContextType.REPORT);
//			linkContext.setSpeciality(inboxItem.getSpecialityNumber());
//			linkContext.setArguments(getArguments());
//			// linkContext.setReferral(inboxItem instanceof ReferralClientInboxItem);
//			if (inboxItem instanceof ReferralClientInboxItem) {
//				linkContext.setRejectedRequest(((ReferralClientInboxItem) inboxItem).isRequestRejected());
//			}
//			linkContext.setResourceString(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
//					.getResourceString("NewMessageReferece.rr"));
//		}
//		return linkContext;
//	}
//
//	private String[] getArguments() {
//		String[] arguments = null;
//		if (inboxItem instanceof ReferralClientInboxItem) {
//			ReferralClientInboxItem referralClientInboxItem = (ReferralClientInboxItem) inboxItem;
//			String attestableTypeName = referralClientInboxItem.getAttestable().getType().name();
//			String id = referralClientInboxItem.isRequestRejected() ? referralClientInboxItem.getRequestId()
//					: referralClientInboxItem.getAttestable().getId();
//			String paientId = referralClientInboxItem.getAttestable().getPatient();
//			arguments = new String[] { attestableTypeName, id, paientId };
//		} else {
//			if (inboxItem != null && inboxItem.getSpecialityNumber() == RoSConstants.SPECIALITY_PATHOLOGY_CYTOLOGY) {
//				arguments = new String[] { inboxItem.getReportId() };
//			} else {
//				arguments = new String[] { getNotificationID(inboxItem) };
//			}
//		}
//		return arguments;
//	}
//
//	private String getNotificationID(ClientInboxItem inboxItem) {
//		if (inboxItem != null && inboxItem.getNumberOfResults() > 0) {
//			ClientRequest request = omInboxDataProvider.getRequest(inboxItem.getResultItem(0).getRequestID());
//			return request.getID();
//		}
//		return null;
//	}
//
//}
