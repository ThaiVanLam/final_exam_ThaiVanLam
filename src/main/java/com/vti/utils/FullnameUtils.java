package com.vti.utils;

public class FullnameUtils {
	public static boolean validateFullname(String fullname) {
		// Kiểm tra null hoặc chuỗi rỗng
		if (fullname == null || fullname.trim().isEmpty()) {
			return false;
		}

		// Biểu thức chính quy: chỉ cho phép chữ cái và khoảng trắng, không ký tự đặc
		// biệt hoặc số
		return fullname.matches("^[A-Za-zÀ-ỹ\\s]+$");
	}
}
