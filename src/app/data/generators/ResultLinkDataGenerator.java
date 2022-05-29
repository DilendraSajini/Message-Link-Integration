package app.data.generators;

import app.context.LinkContext;
import app.data.ResultLinkData;

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
