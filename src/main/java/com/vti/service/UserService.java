package com.vti.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.vti.dto.Project;
import com.vti.repository.UserRepository;

public class UserService {
	private UserRepository userRepository;

	public UserService() throws FileNotFoundException, IOException {
		userRepository = new UserRepository();
	}

	public void printMemberAndLeaderFromProject(Project project) throws ClassNotFoundException, SQLException {
		userRepository.printMemberAndLeaderFromProject(project);
	}
}
