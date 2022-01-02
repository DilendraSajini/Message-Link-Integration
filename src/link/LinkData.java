package link;


/**
 * Contains shareable link related module reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public abstract class LinkData
{
  protected final LinkContext context;
  private static final String MODULE_NAME ="";
  
  protected LinkData(LinkContext context)
  {
    this.context = context;
  }

  /**
   * Client service name that will be called when the reference is opened
   * @return  String with service name
   */
  public abstract String getService();

  /**
   * Name of the reference that will be visible in the message. 
   * @return  String with a reference name.
   */
  public abstract String getReferenceName();

  /**
   * Client Module path identifying referred module
   * @return  String with module path
   */
  public String getModule()
  {
    return MODULE_NAME;
  }

  /**
   * Set message either patient related message or not
   * @return boolean
   */
  public boolean isPatientRelatedMessage()
  {
    return true;
  }

  /**
   * Argument id list to opening the reference.
   * @return  String[] of arguments
   */
  public String[] getArguments()
  {
    return context.getArguments();
  }
}
