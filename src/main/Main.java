package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import app.common.ClientReport;
import app.common.ClientResult;
import app.common.ReportData;
import app.common.SubjectOfCare;
import app.common.exceptions.ClientException;
import app.link.context.LinkContext;
import app.link.data.LinkData;
import app.link.data.generators.LinkDataGeneratorFactory;
import main.helper.LinkContextHelper;
import main.messenger.MessengerReferenceData;

public class Main {

	public static final String MODULE_NAME = "ModuleName.rr";
	public static final Locale currentLocale = Locale.GERMAN;
	public static final Locale swedishLocale = new Locale("sv", "SE");

	public static void main(String[] args) {
		try {
			LinkContext reportContext = LinkContextHelper.buildLinkContext(getClientReport());
			LinkData reportLinkData = new LinkDataGeneratorFactory().getInstance(reportContext).generate();
			System.out.println(new MessengerReferenceData(reportLinkData).getMessageLinkBase());
			LinkContext resultContext = LinkContextHelper.buildLinkContext(getClientResultsList());
			LinkData resultLinkData = new LinkDataGeneratorFactory().getInstance(resultContext).generate();
			System.out.println(new MessengerReferenceData(resultLinkData).getMessageLinkBase());
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	private static ClientReport getClientReport() {
		ClientReport clientReport = new ClientReport();
		ReportData data = new ReportData();
		data.setId("123");
		data.setSoc(new SubjectOfCare());
		clientReport.setData(data);
		ClientResult[] results = getClientResults();
		clientReport.setResults(results);
		return clientReport;
	}

	private static ClientResult[] getClientResults() {
		return new ClientResult[] { getClientResult() };
	}

	private static List<ClientResult> getClientResultsList() {
		return new ArrayList<>(Arrays.asList(getClientResult()));
	}

	private static ClientResult getClientResult() {
		ClientResult clientResult = new ClientResult();
		clientResult.setId("456");
		clientResult.setRequestId("123456");
		return clientResult;
	}
}
