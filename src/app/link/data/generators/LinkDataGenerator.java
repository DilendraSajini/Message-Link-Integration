package app.link.data.generators;

import app.link.context.LinkContext;
import app.link.data.LinkData;

/**
 * Generate link data{@link LinkData}
 * 
 * @author Dilendra Sajini
 *
 * @since Jan 5, 2022
 */
public abstract class LinkDataGenerator {
	
	protected LinkContext linkContext;

	public abstract LinkData generate();
}
