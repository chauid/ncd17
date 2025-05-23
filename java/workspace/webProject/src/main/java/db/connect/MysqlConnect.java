package db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnect {
	static final String MYSQL_DRIVER="org.mariadb.jdbc.Driver";
//    String url="jdbc:mariadb://localhost:3306/test";
    String url="jdbc:mysql://db-324nge-kr.vpc-pub-cdb.ntruss.com:3306/studydb?serverTimezone=Asia/Seoul";
    String username="administrator";
    String password="administrator!9df6b";
    
    public MysqlConnect() {
		// TODO Auto-generated constructor stub
    	try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Driver 오류:"+e.getMessage());
		}
	}
    
    public Connection getConnection()
    {
    	Connection conn=null;
    	try {
			conn=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("mysql 서버 접속 실패:"+e.getMessage());
		}
    	return conn;
    }
    
    public void dbClose(PreparedStatement pstmt,Connection conn)
    {
    	try {
    		if(pstmt!=null) pstmt.close();
    		if(conn!=null) conn.close();
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void dbClose(ResultSet rs, PreparedStatement pstmt,Connection conn)
    {
    	try {
    		if(rs!=null) rs.close();
    		if(pstmt!=null) pstmt.close();
    		if(conn!=null) conn.close();
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    }
}















