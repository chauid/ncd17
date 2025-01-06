package day0106;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnect {
	public static class connectionParams {
		String host = "localhost";
		String username = "root";
		String password = "";
		String database = "";
		String port = "3306";

		public connectionParams() {
		}

		public connectionParams(String host, String username, String password, String database, String port) {
			this.host = host;
			this.username = username;
			this.password = password;
			this.database = database;
			this.port = port;
		}
	}

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			System.out.println("Connection is null");
		}
		return connection;
	}

	public static Connection getConnection(String username, String password, String database) {
		String url = "jdbc:mariadb://localhost:3306/" + database;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Success");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection Fail:" + e.getMessage());
		}
		return connection;
	}

	public static Connection getConnection(connectionParams params) {
		String url = "jdbc:mariadb://" + params.host + ":" + params.port + "/" + params.database;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(url, params.username, params.password);
			System.out.println("Connection Success");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection Fail:" + e.getMessage());
		}
		return connection;
	}

	public static void createConnection(connectionParams params) {
		String url = "jdbc:mariadb://" + params.host + ":" + params.port + "/" + params.database;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(url, params.username, params.password);
			System.out.println("Connection Success");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection Fail:" + e.getMessage());
		}
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("closing Fail" + e.getMessage());
		}
	}
}
