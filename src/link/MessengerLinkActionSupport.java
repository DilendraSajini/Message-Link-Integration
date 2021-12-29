//package link;
//
//import se.cambiosys.client.framework.components.CambioAction;
//import se.cambiosys.client.messengerreferencesupport.MessengerReferenceDataInterface;
//import se.cambiosys.client.messengerreferencesupport.MessengerReferenceSupportToolkit;
//import se.cambiosys.client.messengerreferencesupport.MessengerReferenceSupportToolkitInterface;
//
///**
// * @author Dilendra Sajini
// *
// * @since Dec 23, 2021
// */
//public class MessengerLinkActionSupport {
//	private MessengerReferenceSupportToolkitInterface messengerReferenceSupportToolkit;
//
//	private LinkDataGeneratorFactory linkDataGeneratorFactory;
//
//	private static class InstanceHolder {
//		private static final MessengerLinkActionSupport INSTANCE = new MessengerLinkActionSupport();
//	}
//
//	private MessengerLinkActionSupport() {
//		this.messengerReferenceSupportToolkit = MessengerReferenceSupportToolkit.getInstance();
//		linkDataGeneratorFactory = new LinkDataGeneratorFactory();
//	}
//
//	public static MessengerLinkActionSupport getInstance() {
//		return InstanceHolder.INSTANCE;
//	}
//
//	public CambioAction[] getMenuActions(LinkContext context) {
//		return messengerReferenceSupportToolkit
//				.getMessageReferenceActions(getMessangerReference(linkDataGeneratorFactory.generate(context)));
//	}
//
//	private MessengerReferenceDataInterface[] getMessangerReference(LinkData linkData) {
//		return new MessengerReferenceDataInterface[] { new MessengerReferenceDataInterfaceImpl(linkData) };
//	}
//
//}
