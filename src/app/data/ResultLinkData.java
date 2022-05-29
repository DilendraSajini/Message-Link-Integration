package app.data;

import app.common.constants.ServiceNameConstants;
import app.context.LinkContext;

/**
 * Contains shareable results link related reference data.
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
    return ServiceNameConstants.SERVICE_FOR_RESULT_GET_BY_ID;
  }

  @Override
  public String[] getArguments()
  {
    return context.getResultIds().toArray(new String[0]);
  }

}
