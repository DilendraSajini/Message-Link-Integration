package app.context;

/**
 * @author Dilendra Sajini
 *
 * @since Dec 31, 2021
 */
public final class LinkUtils
{
  private LinkUtils()
  {
  }

  /**
   * Get date string as a suffix with space separator.
   * 
   * @param String dateTime
   * @return String date with space separator.
   */
  public static String getSuffixDateString(String dateTime)
  {
    return (dateTime != null && !dateTime.equals("")) ? extractDate(dateTime) : "";
  }

  /**
   * Extract date from date time string.
   * 
   * @param  String dateTime 
   * @return String date
   */
  public static String extractDate(String dateTime)
  {
    return dateTime.split(" ")[0];
  }
  
  public static String getSpaceAppendedDateString(String dateTime)
  {
    return (dateTime != null && !dateTime.equals("")) ? " " + dateTime : "";
  }
  
  public static String getSpaceAppendedSpecialityString(String speciality)
  {
    return (speciality != null && !speciality.equals("")) ? " " + speciality : "";
  }
}
