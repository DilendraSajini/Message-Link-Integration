package link;

/**
 * Factroy to generate link related module reference data based on the context.
 *  
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public class LinkDataGeneratorFactory
{
  /**
   * Get link data generator by link context.
   * 
   * @param LinkContext {@link LinkContext} 
   *
   * @return {@link LinkData} 
   */
  public LinkData generate(LinkContext context)
  {
    if (context.getType() == LinkContextType.REPORT)
    {
      return getReportLinkData(context);
    }
    if (context.getType() == LinkContextType.RESULT)
    {
      return getResultLinkData(context);
    }
    throw new IllegalArgumentException("Context type should be valid");
  }

  private ResultLinkData getResultLinkData(LinkContext context)
  {
    return new ResultLinkData(context);
  }

  private ReportLinkData getReportLinkData(LinkContext context)
  {
    if (context.getSpeciality() == 0)
    {
      throw new IllegalArgumentException("Context speciality should be valid");
    }
    if (context.getSpeciality() == Constants.NEW_REFERRAL_REFERREL)
    {
      return new ReferralReportLinkData(context);
    }
    if (context.getSpeciality() == Constants.PATHOLOGY_CYTOLOGY)
    {
      return new PathologyReportLinkData(context);
    }
    return new ReportLinkData(context);
  }
}
