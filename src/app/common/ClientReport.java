package app.common;

public class ClientReport {

	private String versionedId;

	private int specialityNumber;

	private ReportData data;

	private String reportId;

	private ClientResult[] results;

	public String getVersionedId() {
		return versionedId;
	}

	public int getSpecialityNumber() {
		return specialityNumber;
	}

	public ReportData getData() {
		return data;
	}

	public boolean isValid() {
		ReportData data = this.getData();
		if (data.id != null && data.id.equals("")) {
			return false;
		} else if (data.soc == null) {
			return false;
		}
		return true;
	}

	public String getReportId() {
		return reportId;
	}

	public ClientResult[] getResults() {
		return results;
	}
}
