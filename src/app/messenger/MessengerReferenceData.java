package app.messenger;

import app.data.LinkData;

public class MessengerReferenceData implements MessengerReferenceDataInterface {
	private LinkData linkData;

	public MessengerReferenceData(LinkData linkData) {
		this.linkData = linkData;
	}

	@Override
	public String getMessageLinkBase() {
		return linkData.getService() + "_" + linkData.getReferenceName() + "_" + linkData.getModule();
	}

	@Override
	public String[] getMessageLinkArguments() {
		return linkData.getArguments();
	}
}
