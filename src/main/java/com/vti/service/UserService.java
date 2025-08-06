package com.vti.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.vti.dto.Member;
import com.vti.dto.Project;
import com.vti.dto.User;
import com.vti.repository.UserRepository;
import com.vti.utils.EmailUtils;
import com.vti.utils.FullnameUtils;
import com.vti.utils.PasswordUtils;

public class UserService {
	private UserRepository userRepository;
	private EmailUtils emailUtils;
	private PasswordUtils passwordUtils;
	private FullnameUtils fullnameUtils;

	public UserService() throws FileNotFoundException, IOException {
		userRepository = new UserRepository();
		emailUtils = new EmailUtils();
		passwordUtils = new PasswordUtils();
		fullnameUtils = new FullnameUtils();
	}

	public void printMemberAndLeaderFromProject(Project project) throws ClassNotFoundException, SQLException {
		userRepository.printMemberAndLeaderFromProject(project);
	}

	public User login(String email, String password) throws Exception {
		if (!emailUtils.isValidEmail(email)) {
			throw new Exception("Email không hợp lệ");
		}
		if (!passwordUtils.isValidPassword(password)) {
			throw new Exception("Password không hợp lệ");
		}
		return userRepository.findByEmailAndPassword(email, password);
	}

	public void createMember(Member member) throws Exception {
		if (!emailUtils.isValidEmail(member.getEmail())) {
			throw new Exception("email không hợp lệ!");
		}
		if (!fullnameUtils.validateFullname(member.getFullname())) {
			throw new Exception("Fullname không hợp lệ!");
		}
		
		userRepository.createMemberFromAdmin(member);

	}
}
