package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1OracleConnect {

	static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
	//db에 접근하려면 url과 id,password 가 필요하다
	String url="jdbc:oracle:thin:@localhost:1521/xe";
	String username="angel";
	String password="pw1234";
	
	public Ex1OracleConnect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패:"+e.getMessage());
		}
	}
	
	//db 연결성공후 Connection 을 반환하는 메서드
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("오라클 접속 성공");
		} catch (SQLException e) {
			System.out.println("오라클 접속 실패:"+e.getMessage());
		}
		return conn;
	}
	
	public void shopWriteData()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from shop";
		
		conn=this.getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);//select sql문은 ResultSet 이 반환되는 executeQuery만 가능
			//여러개인 경우 while문으로 rs.next() 가 true인동안만 반복
			System.out.println("상품코드\t상품명\t상품단가");
			System.out.println("=".repeat(25));
			while(rs.next())
			{
				//컬럼명으로 가져와도 되고 인덱스로 가져와도 된다(인덱스는 1번부터)
//				String code=rs.getString("sangcode");
//				String sname=rs.getString("sangname");
//				int sprice=rs.getInt("sangprice");
				
				String code=rs.getString(1);
				String sname=rs.getString(2);
				int sprice=rs.getInt(3);
				
				System.out.println(code+"\t"+sname+"\t"+sprice);
			}
			
		} catch (SQLException e) {
			System.out.println("sql문 오류:"+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1OracleConnect ex1=new Ex1OracleConnect();//생성자 호출
		ex1.shopWriteData();
	}

}





