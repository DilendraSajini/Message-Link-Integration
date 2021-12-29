package link;


/**
 * @author Dilendra Sajini
 *
 * @since Dec 28, 2021
 */
public class PathologyReportLinkData extends ReportLinkData
{
  public PathologyReportLinkData(LinkContext context)
  {
    super(context);
  }

  @Override
  public String getService()
  {
    return Constants.SERVICE_OPEN_PATHOLOGY_LAB_LIST_FOR_MESSAGE;
  }
}
