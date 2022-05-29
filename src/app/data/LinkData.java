package app.data;

import app.common.constants.SpecialityConstants;
import app.common.delegators.LanguageToolkitDelegator;
import app.common.delegators.SpecialityToolkitDelegator;
import app.context.LinkContext;
import app.context.LinkUtils;
import main.Main;

/**
 * Contains shareable link related module reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public abstract class LinkData
{
  protected SpecialityToolkitDelegator specialityToolkitDelegator;

  protected LanguageToolkitDelegator languageToolkitDelegator;

  protected final LinkContext context;

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
   * Argument id list to opening the reference.
   * @return  String[] of arguments
   */
  public abstract String[] getArguments();

  /**
   * Name of the reference that will be visible in the message. 
   * @return  String with a reference name.
   */
  public String getReferenceName()
  {
    final String RESOURCE_STRING = getLanguageToolkitDelegator().getResourceString(SpecialityConstants.LANGUAGE_RESULT_INBOX,
        true, "NewMessageReferece.rr");
    return RESOURCE_STRING
        + LinkUtils
            .getSpaceAppendedSpecialityString(getSpecialityToolkitDelegator().getSpeciality(context.getSpeciality()))
        + LinkUtils.getSpaceAppendedDateString(context.getTimeStamp());
  }

  /**
   * Client Module path identifying referred module
   * @return  String with module path
   */
  public String getModule()
  {
    return Main.MODULE_NAME;
  }

  SpecialityToolkitDelegator getSpecialityToolkitDelegator()
  {
    if (specialityToolkitDelegator == null)
    {
      specialityToolkitDelegator = SpecialityToolkitDelegator.getInstance();
    }
    return specialityToolkitDelegator;
  }

  LanguageToolkitDelegator getLanguageToolkitDelegator()
  {
    if (languageToolkitDelegator == null)
    {
      languageToolkitDelegator = LanguageToolkitDelegator.getInstance();
    }
    return languageToolkitDelegator;
  }
}