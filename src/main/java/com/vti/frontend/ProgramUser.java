package com.vti.frontend;

import java.util.List;

import com.vti.controller.UserController;

public class ProgramUser {

	public static void main(String[] args) {
		try {
			DataInitializer dataInitializer = new DataInitializer();
			dataInitializer.initData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
