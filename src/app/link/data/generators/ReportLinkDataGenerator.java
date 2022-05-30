package app.link.data.generators;

import app.common.constants.SpecialityConstants;
import app.link.context.LinkContext;
import app.link.data.PathologyReportLinkData;
import app.link.data.ReportLinkData;

/**
 * Generate link data{@link ReportLinkData}
 * 
 * @author Dilendra Sajini
 *
 * @since Jan 5, 2022
 */
public class ReportLinkDataGenerator extends LinkDataGenerator {

	public ReportLinkDataGenerator(LinkContext linkContext) {
		super();
		this.linkContext = linkContext;
	}

	@Override
	public ReportLinkData generate() {
		return getReportLinkData();
	}

	private ReportLinkData getReportLinkData() {
		if (linkContext.getSpeciality() == SpecialityConstants.SPECIALITY_PATHOLOGY_CYTOLOGY) {
			return new PathologyReportLinkData(linkContext);
		} else {
			return new ReportLinkData(linkContext);
		}
	}

}
