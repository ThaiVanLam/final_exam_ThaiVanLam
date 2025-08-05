package com.vti.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dto.Project;
import com.vti.service.UserService;

public class UserController {
	private UserService userService;

	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}
	
	public void printMemberAndLeaderFromProject(Project project) throws ClassNotFoundException, SQLException {
		userService.printMemberAndLeaderFromProject(project);
	}
}
