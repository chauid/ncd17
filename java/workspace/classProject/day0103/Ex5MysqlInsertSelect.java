package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex5MysqlInsertSelect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
    String username="root";
    String password="1234";
    
    public Ex5MysqlInsertSelect() {
		// TODO Auto-generated constructor stub
    	try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 오류:"+e.getMessage());
		}
	}
    
    public Connection getConnection()
    {
    	Connection conn=null;
    	try {
			conn=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Mysql 접속 실패:"+e.getMessage());
		}
    	return conn;
    }
    
    public void insertPerson(String name,String blood,int age,String hp)
    {
    	Connection conn=null;
    	Statement stmt=null;
    	String sql="insert into person (name,blood,age,hp,today) values ("
    			+"'"+name+"','"+blood.toUpperCase()+"',"+age+",'"+hp+"',now())";
    	System.out.println(sql);
    	
    	conn=this.getConnection();
    	try {
			stmt=conn.createStatement();
			//insert문 실행
			stmt.execute(sql);
			
			System.out.println("db 에 데이타를 추가했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    }
    
    public void writePerson()
    {
    	Connection conn=null;
    	Statement stmt=null;
    	ResultSet rs=null;
    	String sql="select * from person order by num";
    	
    	conn=this.getConnection();
    	
    	try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("\t\t** Person Table **");
			System.out.println();
			System.out.println("이름\t나이\t혈액형\t핸드폰\t\t날짜");
			System.out.println("=".repeat(50));
			
			while(rs.next())
			{
				String today=rs.getString("today").substring(0,10);
				
				System.out.println(rs.getString("name")+"\t"+
				 					rs.getInt("age")+"\t"+
				 					rs.getString("blood")+"\t"+
				 					rs.getString("hp")+"\t"+today);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    
    //이름 검색해서 출력하는 메서드
    public void searchName(String name)
    {
    	int count=0;//찾은 인원수를 얻을 변수
    	/*
    	 *   문제: name 이 '영자' 인 경우 영자를 포함하는 모든 데이타 출력
    	 *   
    	 *   예:
    	 *   1번째
    	 *   이름 : 김영자
    	 *   혈액형 : B형
    	 *   나이: 23세
    	 *   핸드폰: 010-2222-3333
    	 *   --------------------
    	 *   2번째
    	 *   이름 :영자순
    	 *   .....
    	 *   
    	 *   
    	 *   
    	 *   만약 없을경우
    	 *      "영자" 를 포함한 회원은 없습니다
    	 *   
    	 */
    	Connection conn=null;
    	Statement stmt=null;
    	ResultSet rs=null;
    	
    	//String sql="select * from person where name like '%"+name+"%'";//방법1
    	String sql="select * from person where name like concat('%','"+name+"','%')";//방법2
    	
    	conn=this.getConnection();
    	try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				count++;
				System.out.println(count+"번째");
				System.out.println("이름 : "+rs.getString("name"));
				System.out.println("혈액형 : "+rs.getString("blood"));
				System.out.println("나이 : "+rs.getInt("age"));
				System.out.println("핸드폰 : "+rs.getString("hp"));
				System.out.println("--------------------");
			}
			
			if(count==0)
				System.out.println("이름에 \""+name+"\" 를 포함하고 있는 회원은 없습니다");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    
    //이름을 찾아 삭제하는 메서드
    public void deletePerson(String name)
    {
    	/*
    	 * name 이 이영자라면
    	 *  이영자가 1명 있을경우
    	 *     1명의 데이타가 삭제되었습니다
    	 *    
    	 *  이영자가 2명 있을 경우
    	 *      2명의 데이타가 삭제되었습니다
    	 *    
    	 *  없을경우
    	 *     "이영자" 님은 존재하지 않습니다  
    	 *     
    	 *     
    	 *   int executeUpdate(String sql)
    	 *      : 실행한 sql문의 갯수를 반환
    	 *     예를 들어 2명이 삭제된경우 2반환
    	 *     1명이 삭제되면 1 반환
    	 *     해당이름이 없어서 삭제를 못했다면 0 반환
    	 */
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5MysqlInsertSelect ex5=new Ex5MysqlInsertSelect();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.데이타 추가  2. 전체출력  3.이름검색 4.멤버삭제 5.종료");
			System.out.println("select menu?");
			int menu=Integer.parseInt(sc.nextLine());
			
			switch(menu)
			{
			case 1:
			{
				System.out.println("데이타를 추가합니다");
				System.out.println("이름을 입력하세요");
				String name=sc.nextLine();
				System.out.println("혈액형을 입력하세요");
				String blood=sc.nextLine();
				System.out.println("나이를 입력하세요");
				int age=Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰을 입력하세요");
				String hp=sc.nextLine();
				
				ex5.insertPerson(name, blood, age, hp);
				break;
			}
			case 2:
				ex5.writePerson();
				break;
			case 3:{
				System.out.println("검색할 이름을 입력하세요");
				String name=sc.nextLine();
				
				ex5.searchName(name);
				break;
			}
			case 4:{
				System.out.println("삭제할 회원의 이름을 입력하세요");
				String name=sc.nextLine();
				
				ex5.deletePerson(name);
				break;
			}
			default:
					System.out.println("** 프로그램을 종료합니다 **");
					System.exit(0);
			}
			System.out.println("--------------");
			
		}
	}

}











