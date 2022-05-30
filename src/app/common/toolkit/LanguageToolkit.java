package app.common.toolkit;

import java.util.ResourceBundle;

import main.Main;

public class LanguageToolkit {
	private LanguageToolkit() {
	}

	public static String language(String key) {
		ResourceBundle words = ResourceBundle.getBundle("resources/language", Main.swedishLocale);
		return words.getString(key);
	}

}
