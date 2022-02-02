package se.cambiosys.client.ros.common.link;

import se.cambiosys.client.ros.common.link.context.LinkContext;

/**
 * Generate link data{@link ResultLinkData} 
 * 
 * @author Dilendra Sajini
 *
 * @since Jan 5, 2022
 */
public class ResultLinkDataGenerator implements LinkDataGenerator
{
  private LinkContext linkContext;
  
  public ResultLinkDataGenerator(LinkContext linkContext)
  {
    super();
    this.linkContext = linkContext;
  }
  
  @Override
  public ResultLinkData generate()
  {
    return new ResultLinkData(linkContext);
  }
}
