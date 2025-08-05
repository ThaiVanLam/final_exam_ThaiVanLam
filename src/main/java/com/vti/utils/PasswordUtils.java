package com.vti.utils;

public class PasswordUtils {
	public static boolean isValidPassword(String password) {
		// Kiểm tra độ dài
		if (password.length() < 6 || password.length() > 10) {
			return false;
		}

		// Kiểm tra có ít nhất 1 ký tự viết hoa
		if (!password.matches(".*[A-Z].*")) {
			return false;
		}

		return true;
	}
}
