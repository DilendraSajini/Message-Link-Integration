//package link;
//
//import se.cambiosys.client.messengerreferencesupport.MessengerReferenceDataInterface;
//
///**
// * @author Dilendra Sajini
// *
// * @since Dec 22, 2021
// */
//public class MessengerReferenceDataInterfaceImpl implements MessengerReferenceDataInterface {
//
//	private LinkData linkData;
//
//	/**
//	 * @param generate
//	 */
//	public MessengerReferenceDataInterfaceImpl(LinkData linkData) {
//		this.linkData = linkData;
//	}
//
//	@Override
//	public boolean isPatientRelatedMessage() {
//		return linkData.isPatientRelatedMessage();
//	}
//
//	@Override
//	public String getService() {
//		return linkData.getService();
//	}
//
//	@Override
//	public String getReferenceName() {
//		return linkData.getReferenceName();
//	}
//
//	@Override
//	public String getModule() {
//		return linkData.getModule();
//	}
//
//	@Override
//	public String[] getArguments() {
//		return linkData.getArguments();
//	}
//
//}
