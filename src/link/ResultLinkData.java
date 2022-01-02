package link;

/**
 * Contains shareable results link related module reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 27, 2021
 */
public class ResultLinkData extends LinkData
{
  public ResultLinkData(LinkContext context)
  {
    super(context);
  }

  @Override
  public String getService()
  {
    return Constants.SERVICE_OPEN_LAB_LIST_FOR_MESSAGE;
  }

  @Override
  public String getReferenceName()
  {
	  return context.getResourceString() + " " + Constants.PATHOLOGY_CYTOLOGY_SPECIALITY;
  }

}
