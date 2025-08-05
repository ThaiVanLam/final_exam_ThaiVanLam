package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.utils.JdbcUltis;

public class UserDao {
	JdbcUltis jdbcUltis;

	public UserDao() throws FileNotFoundException, IOException {
		jdbcUltis = new JdbcUltis();
	}

	public boolean isUserIdExist(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM users WHERE id = " + id;
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
