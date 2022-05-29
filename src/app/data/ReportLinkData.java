package app.data;

import app.common.constants.ServiceNameConstants;
import app.context.LinkContext;

/**
 * Contains shareable report link related reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 27, 2021
 */
public class ReportLinkData extends LinkData
{

  public ReportLinkData(LinkContext context)
  {
    super(context);
  }

  @Override
  public String getService()
  {
    return ServiceNameConstants.SERVICE_FOR_REPORT_GET_BY_ID;
  }

  @Override
  public String[] getArguments()
  {
    return new String[] { context.getRequestId() };
  }
}
