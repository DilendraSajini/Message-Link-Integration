package link;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.testng.annotations.Test;
/**
 * @author Dilendra Sajini
 *
 * @since Dec 30, 2021
 */
public class LinkDataGeneratorFactoryTest
{

  @Test(expectedExceptions = { IllegalArgumentException.class })
  public void testGenerate_whenReportLinkContextDontHaveType()
  {
    LinkDataGeneratorFactory LinkDataGeneratorFactory = new LinkDataGeneratorFactory();

    LinkContext linkContext = new LinkContext();
    linkContext.setArguments(new String[] { "arg1" });
    linkContext.setSpeciality(RoSConstants.SPECIALITY_IMMUNOLOGY);
    linkContext.setResourceString(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"));

    LinkDataGeneratorFactory.generate(linkContext);
  }

  @Test(expectedExceptions = { IllegalArgumentException.class })
  public void testGenerate_whenReportLinkContextDontHaveSpeciality()
  {
    LinkDataGeneratorFactory LinkDataGeneratorFactory = new LinkDataGeneratorFactory();

    LinkContext linkContext = new LinkContext();
    linkContext.setArguments(new String[] { "arg1" });
    linkContext.setResourceString(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"));

    LinkDataGeneratorFactory.generate(linkContext);
  }

  @Test()
  public void testGenerate_whenReportLinkContext()
  {
    LinkDataGeneratorFactory LinkDataGeneratorFactory = new LinkDataGeneratorFactory();

    LinkContext linkContext = new LinkContext();
    linkContext.setArguments(new String[] { "arg1" });
    linkContext.setType(LinkContextType.REPORT);
    linkContext.setSpeciality(RoSConstants.SPECIALITY_IMMUNOLOGY);
    linkContext.setResourceString(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"));

    LinkData linkData = LinkDataGeneratorFactory.generate(linkContext);
    Assert.assertEquals(1, linkData.getArguments().length);
    Assert.assertEquals("arg1", linkData.getArguments()[0]);
    Assert.assertEquals(OMServiceInterface.SERVICE_OPEN_LAB_LIST_FOR_MESSAGE, linkData.getService());
    String referenceName = linkContext.getResourceString() + " "
        + SpecialityToolkit.getSpeciality(linkContext.getSpeciality());
    Assert.assertEquals(referenceName, linkData.getReferenceName());
    Assert.assertEquals(Module.getCompleteModuleInformation().getName(), linkData.getModule());
  }

  @Test()
  public void testGenerate_whenReportLinkContext_Pathology()
  {
    LinkDataGeneratorFactory LinkDataGeneratorFactory = new LinkDataGeneratorFactory();

    LinkContext linkContext = new LinkContext();
    linkContext.setArguments(new String[] { "result 1" });
    linkContext.setType(LinkContextType.REPORT);
    linkContext.setSpeciality(RoSConstants.SPECIALITY_PATHOLOGY_CYTOLOGY);
    linkContext.setResourceString(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"));

    LinkData linkData = LinkDataGeneratorFactory.generate(linkContext);
    Assert.assertEquals(1, linkData.getArguments().length);
    Assert.assertEquals("result 1", linkData.getArguments()[0]);
    Assert.assertEquals(OMServiceInterface.SERVICE_OPEN_PATHOLOGY_LAB_LIST_FOR_MESSAGE, linkData.getService());
    String referenceName = linkContext.getResourceString() + " "
        + SpecialityToolkit.getSpeciality(linkContext.getSpeciality());
    Assert.assertEquals(referenceName, linkData.getReferenceName());
    Assert.assertEquals(Module.getCompleteModuleInformation().getName(), linkData.getModule());
  }

  @Test()
  public void testGenerate_whenReportLinkContext_Referral()
  {
    LinkDataGeneratorFactory LinkDataGeneratorFactory = new LinkDataGeneratorFactory();

    LinkContext linkContext = new LinkContext();
    linkContext.setArguments(new String[] { "result 1" });
    linkContext.setType(LinkContextType.REPORT);
    linkContext.setSpeciality(RoSConstants.NEW_REFERRAL_REFERREL);
    linkContext.setResourceString(ReferenceArguments.MESSAGE_LINK_TEXT_REFERRAL);

    LinkData linkData = LinkDataGeneratorFactory.generate(linkContext);
    Assert.assertEquals(1, linkData.getArguments().length);
    Assert.assertEquals("result 1", linkData.getArguments()[0]);
    Assert.assertEquals(ReferenceArguments.SERVICE_OPEN_LIST_OF_ANSWER_VIEW, linkData.getService());
    Assert.assertEquals(ReferenceArguments.MESSAGE_LINK_TEXT_REFERRAL, linkData.getReferenceName());
    Assert.assertEquals(ReferenceArguments.MODULE_REQUEST_INTERACTION_FACADE, linkData.getModule());
  }

  @Test()
  public void testGenerate_whenResultLinkContext()
  {
    LinkDataGeneratorFactory LinkDataGeneratorFactory = new LinkDataGeneratorFactory();

    LinkContext linkContext = new LinkContext();
    linkContext.setArguments(new String[] { "result 1", "result 2" });
    linkContext.setType(LinkContextType.RESULT);
    linkContext.setSpeciality(RoSConstants.SPECIALITY_CHEMISTRY);
    linkContext.setResourceString(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"));

    LinkData linkData = LinkDataGeneratorFactory.generate(linkContext);
    Assert.assertEquals(2, linkData.getArguments().length);
    Assert.assertTrue(Arrays.asList(linkData.getArguments()).contains("result 1"));
    Assert.assertTrue(Arrays.asList(linkData.getArguments()).contains("result 2"));
    Assert.assertEquals(OMServiceInterface.SERVICE_OPEN_LAB_LIST_FOR_MESSAGE, linkData.getService());
    String referenceName = linkContext.getResourceString() + " "
        + SpecialityToolkit.getSpeciality(linkContext.getSpeciality());
    Assert.assertEquals(referenceName, linkData.getReferenceName());
    Assert.assertEquals(Module.getCompleteModuleInformation().getName(), linkData.getModule());
  }

}
