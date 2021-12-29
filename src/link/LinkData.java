package link;


/**
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public abstract class LinkData
{

  private static final String MODULE_NAME ="";
  
  protected final LinkContext context;

  protected LinkData(LinkContext context)
  {
    this.context = context;
  }

  public abstract String getService();

  public abstract String getReferenceName();

  public String getModule()
  {
    return MODULE_NAME;
  }
  
  public boolean isPatientRelatedMessage()
  {
    return true;
  }
  
  public String[] getArguments()
  {
    return context.getArguments();
  }
}
