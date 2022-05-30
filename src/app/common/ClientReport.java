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

	public void setVersionedId(String versionedId) {
		this.versionedId = versionedId;
	}

	public void setSpecialityNumber(int specialityNumber) {
		this.specialityNumber = specialityNumber;
	}

	public void setData(ReportData data) {
		this.data = data;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public void setResults(ClientResult[] results) {
		this.results = results;
	}

	public boolean isValid() {
		return this.getData().isValid();
	}

	public String getReportId() {
		return reportId;
	}

	public ClientResult[] getResults() {
		return results;
	}
}
