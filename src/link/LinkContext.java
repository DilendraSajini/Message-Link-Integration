package link;

/**
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public class LinkContext
{
  private LinkContextType type;
  
  private int speciality;
  
  private String[] arguments;
  
  private boolean isRejectedRequest;
  
  private String resourceString;
  
  public LinkContextType getType()
  {
    return type;
  }

  public void setType(LinkContextType type)
  {
    this.type = type;
  }

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

  public void setSpeciality(int speciality)
  {
    this.speciality = speciality;
  }

  public boolean isRejectedRequest()
  {
    return isRejectedRequest;
  }

  public void setRejectedRequest(boolean isRejectedRequest)
  {
    this.isRejectedRequest = isRejectedRequest;
  }

  public String getResourceString()
  {
    return resourceString;
  }

  public void setResourceString(String resourceString)
  {
    this.resourceString = resourceString;
  }
}
