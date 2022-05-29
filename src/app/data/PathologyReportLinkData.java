package app.data;

import app.common.constants.ServiceNameConstants;
import app.context.LinkContext;

/**
 * Contains shareable pathology report link related reference data.
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 28, 2021
 */
public class PathologyReportLinkData extends ReportLinkData {
	public PathologyReportLinkData(LinkContext context) {
		super(context);
	}

	@Override
	public String getService() {
		return ServiceNameConstants.SERVICE_OPEN_PATHOLOGY_LAB_LIST_FOR_MESSAGE;
	}

	@Override
	public String[] getArguments() {
		return new String[] { context.getReportId() };
	}
}
