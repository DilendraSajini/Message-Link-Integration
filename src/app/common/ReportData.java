package app.common;

public class ReportData {

	private String id;
	private SubjectOfCare soc;

	public String getId() {
		return id;
	}

	public SubjectOfCare getSoc() {
		return soc;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSoc(SubjectOfCare soc) {
		this.soc = soc;
	}

	public boolean isValid() {
		if (id != null && id.equals("") && soc == null) {
			return false;
		} else {
			return true;
		}
	}
}
