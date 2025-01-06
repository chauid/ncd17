package day0103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost:3307/test";
	private static Connection connect = null;

	public Connection getConnect() {
		return connect;
	}

	public Main() {
		try {
			Class.forName(DRIVER);
			connect = DriverManager.getConnection(DB_URL, "root", "1234");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로드 실패:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 실패:" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Main connectObj = new Main();
		String query = "SELECT * FROM content";
		Connection conn = connectObj.getConnect();
		ResultSet rs = executeQuery(conn, query);
		printResult(rs);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB연결이 없음:" + e.getMessage());
		}
	}

	public static ResultSet executeQuery(Connection connection, String query) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			statement.close();
			return result;
		} catch (SQLException e) {
			System.out.println("쿼리 실행 실패:"+e.getMessage());
		}
		return null;
	}
	
	public static void printResult(ResultSet result) {
		try {
			while(result.next()) {
				ResultSetMetaData rsmd = result.getMetaData();
				int recordSize = rsmd.getColumnCount() + 1;
				for (int i = 1; i < recordSize; i++) {
					System.out.println(result.getString(i));					
				}
			}
		} catch (SQLException e) {
			System.out.println("실행 결과 출력 에러:"+e.getMessage());
		}
	}
}
