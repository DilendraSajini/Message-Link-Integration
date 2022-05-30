package main.messenger;

import app.link.data.LinkData;

public class MessengerReferenceData implements MessengerReferenceDataInterface {
	private LinkData linkData;

	public MessengerReferenceData(LinkData linkData) {
		this.linkData = linkData;
	}

	@Override
	public String getMessageLinkBase() {
		return linkData.getModule() + "_" + linkData.getReferenceName() + "_" + linkData.getService();
	}

	@Override
	public String[] getMessageLinkArguments() {
		return linkData.getArguments();
	}
}
