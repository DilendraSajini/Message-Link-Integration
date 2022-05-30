package app.link.data.generators;

import app.link.context.LinkContext;
import app.link.data.ResultLinkData;

/**
 * Generate link data{@link ResultLinkData}
 * 
 * @author Dilendra Sajini
 *
 * @since Jan 5, 2022
 */
public class ResultLinkDataGenerator extends LinkDataGenerator {

	public ResultLinkDataGenerator(LinkContext linkContext) {
		super();
		this.linkContext = linkContext;
	}

	@Override
	public ResultLinkData generate() {
		return new ResultLinkData(linkContext);
	}
}
