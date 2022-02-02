package se.cambiosys.client.ros.common.link;

import se.cambiosys.client.ros.common.link.context.LinkContext;
import se.cambiosys.client.ros.common.util.toolkit.RoSConstants;

/**
 * Generate link data{@link ReportLinkData} 
 * 
 * @author Dilendra Sajini
 *
 * @since Jan 5, 2022
 */
public class ReportLinkDataGenerator implements LinkDataGenerator
{

  private LinkContext linkContext;

  public ReportLinkDataGenerator(LinkContext linkContext)
  {
    super();
    this.linkContext = linkContext;
  }

  @Override
  public ReportLinkData generate()
  {
    return getReportLinkData();
  }

  private ReportLinkData getReportLinkData()
  {
    switch (linkContext.getSpeciality())
    {
      case RoSConstants.SPECIALITY_PATHOLOGY_CYTOLOGY:
        return new PathologyReportLinkData(linkContext);
      default:
        return new ReportLinkData(linkContext);
    }
  }

}
