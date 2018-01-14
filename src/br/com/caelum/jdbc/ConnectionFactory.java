package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// public ConnectionFactory() {}

	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "root");
			return con;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
