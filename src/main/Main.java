package main;

import java.util.Locale;

import app.common.ClientReport;
import app.common.exceptions.ClientException;
import app.context.LinkContext;
import app.context.LinkContextHelper;
import app.data.LinkData;
import app.data.generators.LinkDataGeneratorFactory;
import app.messenger.MessengerReferenceData;

public class Main {

	public static final String MODULE_NAME = "getByResultId";
	public static final Locale currentLocale = Locale.ENGLISH;

	public static void main(String[] args) {
		ClientReport clientReport = new ClientReport();
		try {
			LinkContext context = LinkContextHelper.buildLinkContext(clientReport);
			LinkData data = new LinkDataGeneratorFactory().getInstance(context).generate();
			System.out.println(new MessengerReferenceData(data).getMessageLinkBase());
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}
