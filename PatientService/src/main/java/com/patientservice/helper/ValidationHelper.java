package com.patientservice.helper;

import java.util.regex.Pattern;

public class ValidationHelper {

	public static boolean patternMatches(String emailAddress) {
		String regexPattern = "^(.+)@(\\S+)$";
		return Pattern.compile(regexPattern).matcher(emailAddress).matches();
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		String regexPattern = "[0-9]+";

		boolean isLengthValid = Pattern.compile("^\\d{10}$").matcher(phoneNumber).matches();
		return phoneNumber.matches(regexPattern) && isLengthValid;
	}

	public static boolean validateDOB(String phoneNumber) {
		String regexPattern = "[0-9]+";

		boolean isLengthValid = Pattern.compile("^\\d{10}$").matcher(phoneNumber).matches();
		return phoneNumber.matches(regexPattern) && isLengthValid;
	}

	public static boolean validateName(String string) {
		int strLength = 0;

		if (string != null) {
			strLength = string.length();

		}
		return ((string != null) && (!string.equals("")) && (string.matches("^[a-zA-Z]*$"))
				&& (strLength >= 5 || strLength <= 30));
	}

	public static boolean validateDrugId(String drugId) {
//		String stringNumber = String.valueOf(drugId);
		String regexPattern = "([0-9]{5})-([0-9]{4})-([0-9]{2})";

		return Pattern.compile(regexPattern).matcher(drugId).matches();
	}

}
