package app.common;

public class ClientResult {

	private String id;

	private String requestId;

	private int speciality;

	private String testTimeActual;

	public String getID() {
		return id;
	}

	public String getRequestID() {
		return requestId;
	}

	public int getSpeciality() {
		return speciality;
	}

	public String getTestTimeActual() {
		return testTimeActual;
	}

	public String getId() {
		return id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setSpeciality(int speciality) {
		this.speciality = speciality;
	}

	public void setTestTimeActual(String testTimeActual) {
		this.testTimeActual = testTimeActual;
	}
}
