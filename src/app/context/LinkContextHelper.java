package app.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import app.common.ClientReport;
import app.common.ClientResult;
import app.common.LanguageToolkit;
import app.common.constants.SpecialityConstants;
import app.common.exceptions.ClientException;

/**
 * Generate context data{@link LinkContext}
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public final class LinkContextHelper {

	private LinkContextHelper() {

	}

	  /**
	   * Generate link context using ClientResult 
	   * Not supported for pathology hence report id is not available with results use {@link #buildLinkContext(ClientInboxItem inboxItem)} 
	   * @return {@link LinkContext} 
	   * @throws ClientException 
	   */
	public static LinkContext buildReportLinkContextWitRequestId(ClientResult result) throws ClientException {
		if (!isValidRequestId(result)) {
			throwsClientException();
		}
		return new LinkContext.LinkContextBuilder(LinkContextType.REPORT, result.getSpeciality())
				.requestId(result.getRequestID()).timeStamp(getTimeStamp(result)).build();
	}

	public static LinkContext buildReportLinkContextWitReportId(ClientReport clientReport, ClientResult clientResult) {
		return new LinkContext.LinkContextBuilder(LinkContextType.REPORT, clientReport.getSpecialityNumber())
				.reportId(clientReport.getReportId()).timeStamp(getTimeStamp(clientResult)).build();
	}

	public static LinkContext buildResultLinkContext(List<ClientResult> clientResults) throws ClientException {
		if (!isValidResultIds(clientResults)) {
			throwsClientException();
		}
		return new LinkContext.LinkContextBuilder(LinkContextType.RESULT, clientResults.get(0).getSpeciality())
				.resultIds(getResultIds(clientResults)).timeStamp(getTimeStamp(clientResults)).build();
	}

	public static LinkContext buildLinkContext(ClientReport clientReport) throws ClientException {
		if (!isValidInboxItem(clientReport)) {
			throwsClientException();
		}
		return buildReportLinkContext(clientReport);
	}

	private static LinkContext buildReportLinkContext(ClientReport clientReport) throws ClientException {
		List<ClientResult> clientResults = clientReport.getResults() != null ? Arrays.asList(clientReport.getResults())
				: new ArrayList<>();
		if (!isValidResults(clientResults)) {
			throwsClientException();
		}
		return buildReportLinkContextWitRequestId(clientResults.get(0));
	}

	private static boolean isValidInboxItem(ClientReport inboxItem) {
		if (inboxItem != null && inboxItem.getSpecialityNumber() == SpecialityConstants.SPECIALITY_PATHOLOGY_CYTOLOGY) {
			return inboxItem.getVersionedId() != null;
		}
		return inboxItem != null && inboxItem.getData() != null && inboxItem.isValid();
	}

	private static boolean isValidResults(List<ClientResult> clientResults) {
		return clientResults != null && !clientResults.isEmpty();
	}

	private static boolean isValidResultIds(List<ClientResult> clientResults) {
		return getResultIds(clientResults) != null && !getResultIds(clientResults).isEmpty();
	}

	private static boolean isValidRequestId(ClientResult result) {
		return isValidId(result.getRequestID());
	}

	private static boolean isValidId(String id) {
		return id != null && !id.isEmpty();
	}

	private static String getTimeStamp(List<ClientResult> clientResults) {
		return getTimeStamp(clientResults.get(0));
	}

	public static String getTimeStamp(ClientResult result) {
		String resultTestTime = result.getTestTimeActual();
		return LinkUtils.getSuffixDateString(resultTestTime);
	}

	private static List<String> getResultIds(List<ClientResult> clientResults) {
		return clientResults.stream().map(ClientResult::getID).filter(id -> !id.isEmpty()).collect(Collectors.toList());
	}

	private static void throwsClientException() throws ClientException {
		throw new ClientException(LanguageToolkit.language("MessageBoxHeading.rr")
				+ LanguageToolkit.language("CorruptedReport.rr"));
	}
}
