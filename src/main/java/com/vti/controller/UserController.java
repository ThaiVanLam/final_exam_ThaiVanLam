package com.vti.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dto.Member;
import com.vti.dto.Project;
import com.vti.dto.User;
import com.vti.service.UserService;

public class UserController {
	private UserService userService;

	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}

	public void printMemberAndLeaderFromProject(Project project) throws ClassNotFoundException, SQLException {
		userService.printMemberAndLeaderFromProject(project);
	}

	public User login(String email, String password) throws Exception {
		return userService.login(email, password);
	}

	public void createMember(Member member) throws Exception {
		userService.createMember(member);
	}
}
