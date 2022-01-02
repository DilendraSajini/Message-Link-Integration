package link;

/**
 * Contains context related information to generate {@link LinkData} from {@link LinkDataGeneratorFactory}
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public class LinkContext
{
  private LinkContextType type;
  
  private int speciality;
  
  private String[] arguments;
  
  private String resourceString;
  
  /**
   * Get link context type.
   * @return {@link LinkContextType} 
   */
  public LinkContextType getType()
  {
    return type;
  }

  public void setType(LinkContextType type)
  {
    this.type = type;
  }

  /**
   * Argument id list to opening the reference.
   * @return String[] of arguments
   */
  public String[] getArguments()
  {
    return arguments;
  }

  public void setArguments(String[] arguments)
  {
    this.arguments = arguments;
  }

  public int getSpeciality()
  {
    return speciality;
  }

  /**
   * Speciality number.
   * @return String[] of arguments
   */
  public void setSpeciality(int speciality)
  {
    this.speciality = speciality;
  }

  /**
   * Resource string value specific to bundle.
   * Use to generate ReferenceName in link data {@link LinkData}.
   * @return String
   */
  public String getResourceString()
  {
    return resourceString;
  }

  public void setResourceString(String resourceString)
  {
    this.resourceString = resourceString;
  }
}
