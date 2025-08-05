package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUltis {
	private Properties properties;
	private Connection connection;

	public JdbcUltis() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/database.properties"));
	}

	public void connectionTesting() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		Class.forName(driver);

		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect Success");
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		Class.forName(driver);

		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	public void disConnection() throws SQLException {
		connection.close();
	}

	public ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet;
	}

	public PreparedStatement createPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;
	}

	public PreparedStatement createPrepareStatement(String sql, Connection connection)
			throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;
	}

	public CallableStatement createCallableStatement(String sql) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		CallableStatement callableStatement = connection.prepareCall(sql);
		return callableStatement;
	}

	

}
