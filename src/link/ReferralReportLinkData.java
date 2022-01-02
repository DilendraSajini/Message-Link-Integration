package link;

/**
 * Contains shareable referral report link related module reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 28, 2021
 */
public class ReferralReportLinkData extends ReportLinkData
{
  public ReferralReportLinkData(LinkContext context)
  {
    super(context);
  }

  @Override
  public String getService()
  {
    return Constants.SERVICE_OPEN_LIST_OF_ANSWER_VIEW;
  }

  @Override
  public String getReferenceName()
  {
    return context.getResourceString();
  }

  @Override
  public String getModule()
  {
    return Constants.MODULE_REQUEST_INTERACTION_FACADE;
  }
}
