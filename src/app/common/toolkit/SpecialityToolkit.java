package app.common.toolkit;

import java.util.Arrays;
import java.util.Optional;

import app.common.Speciality;

public class SpecialityToolkit {

	private SpecialityToolkit() {
	}

	public static String getSpeciality(int number) {
		Optional<Speciality> match = Arrays.asList(Speciality.values()).stream()
				.filter(speciality -> speciality.getNumber() == number).findFirst();
		if (match.isPresent()) {
			return match.get().name();
		}
		return "";
	}

}
