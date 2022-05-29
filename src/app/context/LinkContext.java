package app.context;

import java.util.List;
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

  private String requestId;

  private String reportId;

  private List<String> resultIds;

  private String timeStamp;

  private String paientId;

  private LinkContext(LinkContextBuilder builder)
  {
    this.type = builder.type;
    this.speciality = builder.speciality;
    this.requestId = builder.requestId;
    this.reportId = builder.reportId;
    this.resultIds = builder.resultIds;
    this.timeStamp = builder.timeStamp;
    this.paientId = builder.paientId;
  }

  /**
   * Get link context type.
   * @return {@link LinkContextType} 
   */
  public LinkContextType getType()
  {
    return type;
  }

  /**
   * Speciality number.
   * @return String[] of arguments
   */
  public int getSpeciality()
  {
    return speciality;
  }

  /**
   * Display date string value with in the link.
   * Sampling date for specimen based and investigation date for radiology.
   * 
   * @return String
   */
  public String getTimeStamp()
  {
    return timeStamp;
  }

  public String getReportId()
  {
    return reportId;
  }

  public List<String> getResultIds()
  {
    return resultIds;
  }

  public String getRequestId()
  {
    return requestId;
  }

  public String getPaientId()
  {
    return paientId;
  }

  public static class LinkContextBuilder
  {
    private LinkContextType type;

    private int speciality;

    private String requestId;

    private String reportId;

    private List<String> resultIds;

    private String timeStamp;

    private String paientId;

    public LinkContextBuilder(LinkContextType type, int speciality)
    {
      this.type = type;
      this.speciality = speciality;
    }

    public LinkContextBuilder requestId(String requestId)
    {
      this.requestId = requestId;
      return this;
    }

    public LinkContextBuilder reportId(String reportId)
    {
      this.reportId = reportId;
      return this;
    }

    public LinkContextBuilder resultIds(List<String> resultIds)
    {
      this.resultIds = resultIds;
      return this;
    }

    public LinkContextBuilder timeStamp(String timeStamp)
    {
      this.timeStamp = timeStamp;
      return this;
    }

    public LinkContextBuilder paientId(String paientId)
    {
      this.paientId = paientId;
      return this;
    }

    public LinkContext build()
    {
      return new LinkContext(this);
    }
  }
}
