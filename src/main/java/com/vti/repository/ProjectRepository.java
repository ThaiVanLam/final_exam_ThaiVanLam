package com.vti.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vti.dto.Leader;
import com.vti.dto.Project;
import com.vti.utils.JdbcUltis;

public class ProjectRepository {
	public void createProject(Project project)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		JdbcUltis jdbcUltis = new JdbcUltis();
		String sql = "INSERT INTO projects (project_id, project_name, size, leader_id) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);

		preparedStatement.setInt(1, project.getId());
		preparedStatement.setString(2, project.getName());
		preparedStatement.setInt(3, project.getSize());
		preparedStatement.setInt(4, project.getLeader().getId());

		preparedStatement.executeUpdate();

		jdbcUltis.disConnection();

	}
}
