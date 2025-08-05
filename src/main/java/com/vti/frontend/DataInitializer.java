package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.vti.dto.Leader;
import com.vti.dto.Member;
import com.vti.dto.Project;
import com.vti.repository.ProjectRepository;
import com.vti.repository.UserRepository;

public class DataInitializer {
	UserRepository userRepository;
	ProjectRepository projectRepository;

	public DataInitializer() throws FileNotFoundException, IOException {
		userRepository = new UserRepository();
		projectRepository = new ProjectRepository();
	}

	public static void initData() {
		Leader leader1 = new Leader(1, "fullname 1", "email 1", "password 1", 2);
		Leader leader2 = new Leader(2, "fullname 2", "email 2", "password 2", 2);
		Leader leader3 = new Leader(3, "fullname 3", "email 3", "password 3", 2);

		Project project1 = new Project(1, "name 1", 2, leader1);
		Project project2 = new Project(2, "name 2", 1, leader2);
		Project project3 = new Project(3, "name 3", 2, leader3);

		Member member1 = new Member(4, "fullname 4", "email 4", "skill 4", project1);
		Member member2 = new Member(5, "fullname 5", "email 5", "skill 5", project1);
		Member member3 = new Member(6, "fullname 6", "email 6", "skill 6", project2);
		Member member4 = new Member(7, "fullname 7", "email 7", "skill 7", project3);
		Member member5 = new Member(8, "fullname 8", "email 8", "skill 8", project3);

	}
}
