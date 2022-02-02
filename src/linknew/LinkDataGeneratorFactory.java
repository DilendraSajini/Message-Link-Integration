package se.cambiosys.client.ros.common.link;

import se.cambiosys.client.ros.common.link.context.LinkContext;

/**
 * Provide link data generator that generates link related module reference data based on the context.
 *  
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public class LinkDataGeneratorFactory
{
  /**
   * Get getInstance by link context.
   * 
   * @param LinkContext {@link LinkContext} 
   *
   * @return {@link LinkData} 
   */
  public LinkDataGenerator getInstance(LinkContext context)
  {
    switch (context.getType())
    {
      case REPORT:
        return new ReportLinkDataGenerator(context);
      case RESULT:
        return new ResultLinkDataGenerator(context);
      default:
        throw new IllegalArgumentException("Context type should be valid");
    }
  }
}
