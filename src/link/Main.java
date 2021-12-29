package link;

public class Main {

	public static void main(String[] args) {
		LinkContext linkContext = new LinkContext();
		linkContext.setType(LinkContextType.REPORT);
		linkContext.setSpeciality(Constants.PATHOLOGY_CYTOLOGY);
		linkContext.setArguments(getArguments());
		linkContext.setRejectedRequest(false);
		linkContext.setResourceString(Constants.RESOURCE_STRING);
		
//		 LinkContext context = new ReportLinkContextGenerator(getNotificationItem()).generate();
//	      CambioAction[] messageActions = MessengerLinkActionSupport.getInstance().getMenuActions(context);
	}

	private static String[] getArguments() {
		return null;

	}
}
