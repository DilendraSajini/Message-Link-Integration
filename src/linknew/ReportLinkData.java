package se.cambiosys.client.ros.common.link;

import se.cambiosys.client.ros.common.link.context.LinkContext;
import se.cambiosys.client.ros.common.util.service.OMServiceInterface;

/**
 * Contains shareable report link related module reference data.
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
    return OMServiceInterface.SERVICE_OPEN_LAB_LIST_FOR_MESSAGE;
  }

  @Override
  public String[] getArguments()
  {
    return new String[] { context.getRequestId() };
  }
}
