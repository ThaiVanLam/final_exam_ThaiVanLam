package com.vti.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.vti.DAO.LeaderDao;
import com.vti.DAO.MemberDao;
import com.vti.DAO.UserDao;
import com.vti.dto.Leader;
import com.vti.dto.Member;
import com.vti.dto.Project;
import com.vti.dto.User;
import com.vti.utils.JdbcUltis;

public class UserRepository {
	JdbcUltis jdbcUltis;
	UserDao userDao;
	MemberDao memberDao;
	LeaderDao leaderDao;

	public UserRepository() throws FileNotFoundException, IOException {
		jdbcUltis = new JdbcUltis();
		userDao = new UserDao();
		memberDao = new MemberDao();
		leaderDao = new LeaderDao();
	}

	public void createMember(Member member) throws Exception {
		int id = member.getId();
		if (userDao.isUserIdExist(id) || memberDao.isMemberIdExist(id)) {
			throw new Exception("id này đã tồn tại");
		}

		String sqlForCreateUser = "INSERT INTO users (id, fullname, email, user_type) VALUES (?, ?, ?, ?)";
		String sqlForCreateMember = "INSERT INTO members (user_id, project_id, skill) VALUES (?, ?, ?)";

		PreparedStatement preparedStatementForCreateUser = jdbcUltis.createPrepareStatement(sqlForCreateUser);
		PreparedStatement preparedStatementForCreateMember = jdbcUltis.createPrepareStatement(sqlForCreateMember);

		// set parameter for create user
		preparedStatementForCreateUser.setInt(1, id);
		preparedStatementForCreateUser.setString(2, member.getFullname());
		preparedStatementForCreateUser.setString(3, member.getEmail());
		preparedStatementForCreateUser.setString(4, "member");

		// set parameter for create member
		preparedStatementForCreateMember.setInt(1, id);
		preparedStatementForCreateMember.setInt(2, member.getProject().getId());
		preparedStatementForCreateMember.setString(3, member.getSkill());

		// execute query
		preparedStatementForCreateUser.executeUpdate();
		preparedStatementForCreateMember.executeUpdate();
	}

	public void createLeader(Leader leader) throws ClassNotFoundException, SQLException, Exception {
		int id = leader.getId();
		if (userDao.isUserIdExist(id) || leaderDao.isLeaderIdExist(id)) {
			throw new Exception("id này đã tồn tại");
		}

		String sqlForCreateUser = "INSERT INTO users (id, fullname, email, user_type) VALUES (?, ?, ?, ?)";
		String sqlForCreateLeader = "INSERT INTO leaders (user_id, number_of_project) VALUES (?, ?)";

		PreparedStatement preparedStatementForCreateUser = jdbcUltis.createPrepareStatement(sqlForCreateUser);
		PreparedStatement preparedStatementForCreateLeader = jdbcUltis.createPrepareStatement(sqlForCreateLeader);

		// set parameter for create user
		preparedStatementForCreateUser.setInt(1, id);
		preparedStatementForCreateUser.setString(2, leader.getFullname());
		preparedStatementForCreateUser.setString(3, leader.getEmail());
		preparedStatementForCreateUser.setString(4, "leader");

		preparedStatementForCreateLeader.setInt(1, id);
		preparedStatementForCreateLeader.setInt(2, leader.getNumberOfProject());

		// execute query
		preparedStatementForCreateUser.executeUpdate();
		preparedStatementForCreateLeader.executeUpdate();
	}

	public void createAdmin(User user) throws Exception {
		int id = user.getId();
		if (userDao.isUserIdExist(id)) {
			throw new Exception("id đã tồn tại");
		}
		String sql = "INSERT INTO users (id, fullname, email, password, user_type) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, user.getFullname());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, "admin");

		// execute query
		preparedStatement.executeUpdate();
	}

	public void printMemberAndLeaderFromProject(Project project) throws ClassNotFoundException, SQLException {
		String sqlForLeader = "SELECT * FROM projects p INNER JOIN leaders l ON p.leader_id = l.user_id INNER JOIN users u ON u.id = l.user_id WHERE p.project_id = "
				+ project.getId();
		ResultSet resultSetForLeader = jdbcUltis.executeQuery(sqlForLeader);

		System.out.println("In thông tin leader của project có id là: " + project.getId());
		// In tiêu đề cột
		System.out.printf("%-20s %-20s %-20s %-20s\n", "leader id", "fullname", "email", "number of project");
		System.out.println("--------------------------------------------------------------------------------");
		while (resultSetForLeader.next()) {
			int leaderId = resultSetForLeader.getInt("leader_id");
			String fullname = resultSetForLeader.getString("fullname");
			String email = resultSetForLeader.getString("email");
			int numberOfProject = resultSetForLeader.getInt("number_of_project");

			// In dữ liệu
			System.out.printf("%-20d %-20s %-20s %-20d\n", leaderId, fullname, email, numberOfProject);
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		String sqlForMember = "SELECT * FROM projects p INNER JOIN members m ON p.project_id = m.project_id INNER JOIN users u ON m.user_id = u.id WHERE p.project_id = "
				+ project.getId();
		ResultSet resultSetForMember = jdbcUltis.executeQuery(sqlForMember);
		System.out.println("In thông tin member của project có id là: " + project.getId());
		// In tiêu đề cột
		System.out.printf("%-20s %-20s %-20s %-20s\n", "member id", "fullname", "email", "skill");
		System.out.println("--------------------------------------------------------------------------------");
		while (resultSetForMember.next()) {
			int member_id = resultSetForMember.getInt("user_id");
			String fullname = resultSetForMember.getString("fullname");
			String email = resultSetForMember.getString("email");
			String skill = resultSetForMember.getString("skill");

			// In dữ liệu
			System.out.printf("%-20d %-20s %-20s %-20s\n", member_id, fullname, email, skill);
		}
	}

	public User findByEmailAndPassword(String email, String password) throws ClassNotFoundException, SQLException {
		User user = null;
		String sql = "SELECT * FROM users WHERE email = " + "'" + email + "'" + " AND password = " + "'" + password
				+ "'";
		ResultSet resultSet = jdbcUltis.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String fullname = resultSet.getString("fullname");
			String emailFromDB = resultSet.getString("email");
			String userType = resultSet.getString("user_type");
			user = new User(id, fullname, emailFromDB, userType);
		}

		return user;
	}

	public void createMemberFromAdmin(Member member) throws Exception {
		int id = member.getId();
		if (userDao.isUserIdExist(id) || memberDao.isMemberIdExist(id)) {
			throw new Exception("id này đã tồn tại");
		}

		String sqlForCreateUser = "INSERT INTO users (id, fullname, email, password, user_type) VALUES (?, ?, ?, ?, ?)";
		String sqlForCreateMember = "INSERT INTO members (user_id, skill) VALUES (?, ?)";

		PreparedStatement preparedStatementForCreateUser = jdbcUltis.createPrepareStatement(sqlForCreateUser);
		PreparedStatement preparedStatementForCreateMember = jdbcUltis.createPrepareStatement(sqlForCreateMember);

		// set parameter for create user
		preparedStatementForCreateUser.setInt(1, id);
		preparedStatementForCreateUser.setString(2, member.getFullname());
		preparedStatementForCreateUser.setString(3, member.getEmail());
		preparedStatementForCreateUser.setString(4, member.getPassword());
		preparedStatementForCreateUser.setString(5, "member");

		// set parameter for create member
		preparedStatementForCreateMember.setInt(1, id);
		preparedStatementForCreateMember.setString(2, member.getSkill());

		// execute query
		preparedStatementForCreateUser.executeUpdate();
		preparedStatementForCreateMember.executeUpdate();
	}

}
