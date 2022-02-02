package se.cambiosys.client.ros.common.link;

import se.cambiosys.client.ros.common.link.context.LinkContext;
import se.cambiosys.client.ros.common.util.service.OMServiceInterface;

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
    return OMServiceInterface.SERVICE_SHOW_LAB_LIST_BY_RESULT_IDS;
  }

  @Override
  public String[] getArguments()
  {
    return context.getResultIds().toArray(new String[0]);
  }

}
