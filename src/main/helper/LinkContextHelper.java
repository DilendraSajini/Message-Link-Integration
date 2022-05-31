package main.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import app.common.ClientReport;
import app.common.ClientResult;
import app.common.constants.SpecialityConstants;
import app.common.exceptions.ClientException;
import app.common.toolkit.LanguageToolkit;
import app.link.context.LinkContext;
import app.link.context.LinkContextType;
import app.link.context.LinkUtils;

/**
 * Generate context data{@link LinkContext}
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 23, 2021
 */
public final class LinkContextHelper {

	public static final String CORRUPTED_RESULT = "CorruptedResult.rr";

	public static final String CORRUPTED_REPORT = "CorruptedReport.rr";

	private LinkContextHelper() {

	}

	/**
	 * Generate link context using ClientResult
	 * 
	 * @return {@link LinkContext}
	 * @throws ClientException
	 */
	public static LinkContext buildLinkContext(ClientResult result) throws ClientException {
		if (!isValidRequestId(result)) {
			throwsClientException(LanguageToolkit.language(CORRUPTED_RESULT));
		}
		return new LinkContext.LinkContextBuilder(LinkContextType.REPORT, result.getSpeciality())
				.requestId(result.getRequestID()).timeStamp(getTimeStamp(result)).build();
	}

	/**
	 * Generate link context using ClientResult, ClientReport
	 * 
	 * @return {@link LinkContext}
	 * @throws ClientException
	 */
	public static LinkContext buildLinkContext(ClientReport clientReport, ClientResult clientResult) {
		return new LinkContext.LinkContextBuilder(LinkContextType.REPORT, clientReport.getSpecialityNumber())
				.reportId(clientReport.getReportId()).timeStamp(getTimeStamp(clientResult)).build();
	}

	/**
	 * Generate link context using multiple ClientResult
	 * 
	 * @return {@link LinkContext}
	 * @throws ClientException
	 */
	public static LinkContext buildLinkContext(List<ClientResult> clientResults) throws ClientException {
		if (!isValidResultIds(clientResults)) {
			throwsClientException(LanguageToolkit.language(CORRUPTED_RESULT));
		}
		return new LinkContext.LinkContextBuilder(LinkContextType.RESULT, clientResults.get(0).getSpeciality())
				.resultIds(getResultIds(clientResults)).timeStamp(getTimeStamp(clientResults)).build();
	}

	/**
	 * Generate link context using ClientReport
	 * 
	 * @return {@link LinkContext}
	 * @throws ClientException
	 */
	public static LinkContext buildLinkContext(ClientReport clientReport) throws ClientException {
		if (!isValidClientReport(clientReport)) {
			throwsClientException(LanguageToolkit.language(CORRUPTED_REPORT));
		}
		return buildLinkContextByReportResults(clientReport);
	}

	private static LinkContext buildLinkContextByReportResults(ClientReport clientReport) throws ClientException {
		List<ClientResult> clientResults = clientReport.getResults() != null ? Arrays.asList(clientReport.getResults())
				: new ArrayList<>();
		if (!isValidResults(clientResults)) {
			throwsClientException(LanguageToolkit.language(CORRUPTED_RESULT));
		}
		return buildLinkContext(clientResults.get(0));
	}

	private static boolean isValidClientReport(ClientReport clientReport) {
		if (clientReport != null
				&& clientReport.getSpecialityNumber() == SpecialityConstants.SPECIALITY_PATHOLOGY_CYTOLOGY) {
			return clientReport.getVersionedId() != null;
		}
		return clientReport != null && clientReport.getData() != null && clientReport.isValid();
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

	private static void throwsClientException(String msg) throws ClientException {
		throw new ClientException(LanguageToolkit.language(msg));
	}
}
