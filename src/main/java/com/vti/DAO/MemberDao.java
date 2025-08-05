package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vti.utils.JdbcUltis;

public class MemberDao {
	private JdbcUltis jdbcUltis;

	public MemberDao() throws FileNotFoundException, IOException {
		jdbcUltis = new JdbcUltis();
	}

	public boolean isMemberIdExist(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM members WHERE user_id = " + id;
		ResultSet resultSet = jdbcUltis.executeQuery(sql);
		if (resultSet.next()) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}
}
