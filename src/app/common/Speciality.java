package app.common;

public enum Speciality {
	CHEMISTRY(1), MICROBIOLOGY(2), IMMUNOLOGY(3), PATHOLOGY_CYTOLOGY(4), RADIOLOGY(5);

	private int number;

	public int getNumber() {
		return number;
	}

	Speciality(int number) {
		this.number = number;
	}

}
