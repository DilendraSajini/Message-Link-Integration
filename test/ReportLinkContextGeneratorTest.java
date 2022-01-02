package link;

import org.fest.reflect.core.Reflection;
import org.junit.Assert;
import org.mockito.Mockito;
import org.testng.annotations.Test;
public class ReportLinkContextGeneratorTest
{
  @Test()
  public void testGenerate_whenClientInboxItemNull()
  {
    ClientInboxItem clientInboxItem = null;
    ReportLinkContextGenerator reportLinkContextGenerator = new ReportLinkContextGenerator(clientInboxItem);
    LinkContext linkContext = reportLinkContextGenerator.generate();

    Assert.assertNull(linkContext.getArguments());
    Assert.assertNull(linkContext.getType());
    Assert.assertEquals(0, linkContext.getSpeciality());
    Assert.assertNull(linkContext.getResourceString());
  }

  @Test()
  public void testGenerate_whenClientInboxItemEmpty()
  {
    ClientInboxItem clientInboxItem = new ClientInboxItem();
    ReportLinkContextGenerator reportLinkContextGenerator = new ReportLinkContextGenerator(clientInboxItem);
    LinkContext linkContext = reportLinkContextGenerator.generate();

    Assert.assertNull(linkContext.getArguments());
    Assert.assertNull(linkContext.getType());
    Assert.assertEquals(0, linkContext.getSpeciality());
    Assert.assertNull(linkContext.getResourceString());
  }

  @Test()
  public void testGenerate_whenClientInboxItemHasNoResults()
  {
    //Todo: check valida senario for not showing results specialities ex: Microbiology, Immunology 
    ClientInboxItem clientInboxItem = new ClientInboxItem();
    clientInboxItem.setID("111");
    clientInboxItem.setSpecialityNumber(RoSConstants.SPECIALITY_IMMUNOLOGY);
    ReportLinkContextGenerator reportLinkContextGenerator = new ReportLinkContextGenerator(clientInboxItem);
    LinkContext linkContext = reportLinkContextGenerator.generate();

    Assert.assertEquals(0, linkContext.getArguments().length);
    Assert.assertEquals(LinkContextType.REPORT, linkContext.getType());
    Assert.assertEquals(RoSConstants.SPECIALITY_IMMUNOLOGY, linkContext.getSpeciality());
    Assert.assertEquals(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"), linkContext.getResourceString());
  }

  @Test()
  public void testGenerate_whenClientInboxItemHasResults_shouldReturnRequestIdAsArguments()
  {
    ClientInboxItem clientInboxItem = new ClientInboxItem();
    clientInboxItem.setID("111");
    ClientResult result = new ClientResult();
    result.setSpeciality(RoSConstants.SPECIALITY_IMMUNOLOGY);
    result.setID("123");
    clientInboxItem.setResultVector(new ClientResult[] { result });
    clientInboxItem.setSpecialityNumber(RoSConstants.SPECIALITY_IMMUNOLOGY);

    OMInboxItemDataService mockOMInboxDataProvider = Mockito.mock(OMInboxItemDataService.class);
    ClientRequest request = new ClientRequest();
    request.setID("req1");
    Mockito.when(mockOMInboxDataProvider.getRequest(Mockito.any())).thenReturn(request);
    ReportLinkContextGenerator reportLinkContextGenerator = new ReportLinkContextGenerator(clientInboxItem);
    Reflection.field("omInboxDataProvider").ofType(OMInboxItemDataService.class).in(reportLinkContextGenerator)
        .set(mockOMInboxDataProvider);
    LinkContext linkContext = reportLinkContextGenerator.generate();

    Assert.assertEquals(1, linkContext.getArguments().length);
    Assert.assertTrue(Arrays.asList(linkContext.getArguments()).contains("req1"));
    Assert.assertEquals(LinkContextType.REPORT, linkContext.getType());
    Assert.assertEquals(RoSConstants.SPECIALITY_IMMUNOLOGY, linkContext.getSpeciality());
    Assert.assertEquals(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"), linkContext.getResourceString());
  }

  @Test()
  public void testGenerate_whenClientInboxItemHasResults_shouldReturnSamplingTimeNull()
  {
    ClientInboxItem clientInboxItem = new ClientInboxItem();
    clientInboxItem.setID("111");
    ClientResult result = new ClientResult();
    result.setSpeciality(RoSConstants.SPECIALITY_IMMUNOLOGY);
    result.setID("123");
    result.setTestTimeActual(null);
    clientInboxItem.setResultVector(new ClientResult[] { result });
    clientInboxItem.setSpecialityNumber(RoSConstants.SPECIALITY_IMMUNOLOGY);

    OMInboxItemDataService mockOMInboxDataProvider = Mockito.mock(OMInboxItemDataService.class);
    ClientRequest request = new ClientRequest();
    request.setID("req1");
    Mockito.when(mockOMInboxDataProvider.getRequest(Mockito.any())).thenReturn(request);
    ReportLinkContextGenerator reportLinkContextGenerator = new ReportLinkContextGenerator(clientInboxItem);
    Reflection.field("omInboxDataProvider").ofType(OMInboxItemDataService.class).in(reportLinkContextGenerator)
        .set(mockOMInboxDataProvider);
    LinkContext linkContext = reportLinkContextGenerator.generate();

    Assert.assertEquals(1, linkContext.getArguments().length);
    Assert.assertTrue(Arrays.asList(linkContext.getArguments()).contains("req1"));
    Assert.assertEquals(LinkContextType.REPORT, linkContext.getType());
    Assert.assertEquals(RoSConstants.SPECIALITY_IMMUNOLOGY, linkContext.getSpeciality());
    Assert.assertEquals(LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
        .getResourceString("NewMessageReferece.rr"), linkContext.getResourceString());
  }

  @Test()
  public void testGenerate_whenClientInboxItemHasResults_shouldReturnSamplingTimeInResourceString()
  {
    ClientInboxItem clientInboxItem = new ClientInboxItem();
    clientInboxItem.setID("111");
    ClientResult result = new ClientResult();
    result.setSpeciality(RoSConstants.SPECIALITY_IMMUNOLOGY);
    result.setID("123");
    result.setTestTimeActual("2018-03-18 10:40:00");
    clientInboxItem.setResultVector(new ClientResult[] { result });
    clientInboxItem.setSpecialityNumber(RoSConstants.SPECIALITY_IMMUNOLOGY);

    OMInboxItemDataService mockOMInboxDataProvider = Mockito.mock(OMInboxItemDataService.class);
    ClientRequest request = new ClientRequest();
    request.setID("req1");
    Mockito.when(mockOMInboxDataProvider.getRequest(Mockito.any())).thenReturn(request);
    ReportLinkContextGenerator reportLinkContextGenerator = new ReportLinkContextGenerator(clientInboxItem);
    Reflection.field("omInboxDataProvider").ofType(OMInboxItemDataService.class).in(reportLinkContextGenerator)
        .set(mockOMInboxDataProvider);
    LinkContext linkContext = reportLinkContextGenerator.generate();

    Assert.assertEquals(1, linkContext.getArguments().length);
    Assert.assertTrue(Arrays.asList(linkContext.getArguments()).contains("req1"));
    Assert.assertEquals(LinkContextType.REPORT, linkContext.getType());
    Assert.assertEquals(RoSConstants.SPECIALITY_IMMUNOLOGY, linkContext.getSpeciality());
    Assert
        .assertEquals(
            LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
                .getResourceString("NewMessageReferece.rr") + " " + "2018-03-18",
            linkContext.getResourceString());
  }
  
  @Test()
  public void testGenerate_whenRadiologyClientInboxItem()
  {
    ClientInboxItem clientInboxItem = new ClientInboxItem();
    clientInboxItem.setID("111");
    ClientResult result = new ClientResult();
    result.setSpeciality(RoSConstants.SPECIALITY_RADIOLOGY);
    result.setID("123");
    result.setTestTimeActual("2018-03-18 10:40:00");
    clientInboxItem.setResultVector(new ClientResult[] { result });
    clientInboxItem.setSpecialityNumber(RoSConstants.SPECIALITY_RADIOLOGY);

    OMInboxItemDataService mockOMInboxDataProvider = Mockito.mock(OMInboxItemDataService.class);
    ClientRequest request = new ClientRequest();
    request.setID("req1");
    Mockito.when(mockOMInboxDataProvider.getRequest(Mockito.any())).thenReturn(request);
    ReportLinkContextGenerator reportLinkContextGenerator = new ReportLinkContextGenerator(clientInboxItem);
    Reflection.field("omInboxDataProvider").ofType(OMInboxItemDataService.class).in(reportLinkContextGenerator)
        .set(mockOMInboxDataProvider);
    LinkContext linkContext = reportLinkContextGenerator.generate();

    Assert.assertEquals(1, linkContext.getArguments().length);
    Assert.assertTrue(Arrays.asList(linkContext.getArguments()).contains("req1"));
    Assert.assertEquals(LinkContextType.REPORT, linkContext.getType());
    Assert.assertEquals(RoSConstants.SPECIALITY_RADIOLOGY, linkContext.getSpeciality());
    Assert
        .assertEquals(
            LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
                .getResourceString("NewMessageReferece.rr") + " " + "2018-03-18",
            linkContext.getResourceString());
  }
}
