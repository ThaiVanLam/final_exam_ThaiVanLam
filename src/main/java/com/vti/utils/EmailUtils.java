package com.vti.utils;

public class EmailUtils {
	public static boolean isValidEmail(String email) {
		String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(regex);
	}
}
