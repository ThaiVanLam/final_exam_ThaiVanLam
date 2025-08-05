package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.utils.JdbcUltis;

public class LeaderDao {
	private JdbcUltis jdbcUltis;

	public LeaderDao() throws FileNotFoundException, IOException {
		jdbcUltis = new JdbcUltis();
	}

	public boolean isLeaderIdExist(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM leaders WHERE user_id = " + id;
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
