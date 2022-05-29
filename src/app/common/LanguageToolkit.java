package app.common;

import java.util.ResourceBundle;

import main.Main;

public class LanguageToolkit {

	public static String language(String key) {
		ResourceBundle words = ResourceBundle.getBundle("resources/language", Main.currentLocale);
		return words.getString(key);
	}

}
