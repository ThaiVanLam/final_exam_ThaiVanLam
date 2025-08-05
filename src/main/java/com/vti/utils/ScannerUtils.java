package com.vti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerUtils {
	public static Scanner scanner = new Scanner(System.in);

	public static byte inputByte() {
		while (true) {
			try {
				byte number = Byte.parseByte(scanner.nextLine());
				return number;
			} catch (NumberFormatException e) {
				System.err.println("Nhập lại!");
			}
		}
	}

	public static int inputInt() {

		while (true) {
			try {
				int number = Integer.parseInt(scanner.nextLine());
				return number;
			} catch (NumberFormatException e) {
				System.err.println("Nhập lại!");
			}
		}

	}

	public static float inputFloat() {
		while (true) {
			try {
				float number = Float.parseFloat(scanner.nextLine());
				return number;
			} catch (NumberFormatException e) {
				System.err.println("Nhập lại!");
			}
		}
	}

	public static double inputDouble() {
		while (true) {
			try {
				double number = Double.parseDouble(scanner.nextLine());
				return number;
			} catch (NumberFormatException e) {
				System.err.println("Nhập lại!");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String inputString = scanner.nextLine();

			if (!inputString.isEmpty()) {
				return inputString;
			} else {
				System.err.println("Nhập lại");
			}
		}
	}

	public static Date inputDate() {
		String dateInput = scanner.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = sdf.parse(dateInput);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return date;
	}
}
