package app.link.data;

import app.common.toolkit.LanguageToolkit;
import app.common.toolkit.SpecialityToolkit;
import app.link.context.LinkContext;
import app.link.context.LinkUtils;
import main.Main;

/**
 * Contains shareable link related module reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public abstract class LinkData {

	protected final LinkContext context;

	protected LinkData(LinkContext context) {
		this.context = context;
	}

	/**
	 * Client service name that will be called when the reference is opened
	 * 
	 * @return String with service name
	 */
	public abstract String getService();

	/**
	 * Argument id list to opening the reference.
	 * 
	 * @return String[] of arguments
	 */
	public abstract String[] getArguments();

	/**
	 * Name of the reference that will be visible in the message.
	 * 
	 * @return String with a reference name.
	 */
	public String getReferenceName() {
		final String RESOURCE_STRING = LanguageToolkit.language("NewMessageReferece.rr");
		return RESOURCE_STRING
				+ LinkUtils.getSpaceAppendedSpecialityString(
						SpecialityToolkit.getSpeciality(context.getSpeciality()))
				+ LinkUtils.getSpaceAppendedDateString(context.getTimeStamp());
	}

	/**
	 * Client Module path identifying referred module
	 * 
	 * @return String with module path
	 */
	public String getModule() {
		return LanguageToolkit.language(Main.MODULE_NAME);
	}
}
