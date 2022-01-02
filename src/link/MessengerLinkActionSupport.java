//package link;
//
//import se.cambiosys.client.framework.components.CambioAction;
//import se.cambiosys.client.messengerreferencesupport.MessengerReferenceDataInterface;
//import se.cambiosys.client.messengerreferencesupport.MessengerReferenceSupportToolkit;
//import se.cambiosys.client.messengerreferencesupport.MessengerReferenceSupportToolkitInterface;
//
/**
 * Helper class to get the Action from messenger module.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
//public class MessengerLinkActionSupport
//{
//  private MessengerReferenceSupportToolkitInterface messengerReferenceSupportToolkit;
//
//  private LinkDataGeneratorFactory linkDataGeneratorFactory;
//
//  private static class InstanceHolder
//  {
//    private static final MessengerLinkActionSupport INSTANCE = new MessengerLinkActionSupport();
//  }
//
//  private MessengerLinkActionSupport()
//  {
//    this.messengerReferenceSupportToolkit = MessengerReferenceSupportToolkit.getInstance();
//    linkDataGeneratorFactory = new LinkDataGeneratorFactory();
//  }
//
//  public static MessengerLinkActionSupport getInstance()
//  {
//    return InstanceHolder.INSTANCE;
//  }
//
//  /**
//   * Get component link actions by link context.
//   * 
//   * @param context {@link LinkContext} 
//   * @return CambioAction[]
//   */
//  public CambioAction[] getComponentActions(LinkContext context)
//  {
//    return messengerReferenceSupportToolkit
//        .getMessageReferenceActions(getMessangerReference(linkDataGeneratorFactory.generate(context)));
//  }
//
//  private MessengerReferenceDataInterface[] getMessangerReference(LinkData linkData)
//  {
//    return new MessengerReferenceDataInterface[] { new MessengerReferenceDataInterfaceImpl(linkData) };
//  }
//
//}
