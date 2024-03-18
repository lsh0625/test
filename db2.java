package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.management.loading.PrivateClassLoader;

public class db2 {
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final static String USER_ID = "system";
	private final static String USER_PW = "oracle";

	//static
	static
	Connection con = null;
	static
	PreparedStatement pstmt = null;
	static
	ResultSet rs = null;
	public static void select() throws SQLException, ClassNotFoundException{
		
	

		// TODO Auto-generated method stub
		
		try {
			Class.forName(DRIVER);
			//System.out.println("Class.forName(DRIVER)");
				con = DriverManager.getConnection(URL,USER_ID,USER_PW);
				//System.out.println("DriverManager.getConnection(URL,USER_ID,USER_PW)");
				String query = "select id, name, CONTENT, post_date from Test_Board";
				pstmt = con.prepareStatement(query);
				//System.out.println("pstmt = con.prepareStatement(query)");
				rs = pstmt.executeQuery();
				//System.out.println("rs.next()");
				while(rs.next()) {
					String id=rs.getString("ID");
					String name=rs.getString("name");
					String ctt=rs.getString("content");
					String date=rs.getString("post_date");
					System.out.println("ID: "+id+", NAME: "+name+", CONTENT: "+ctt+", DATE: "+date);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			
			}
			
	}


public static void insert(String id, String name, String ctt, String date) throws SQLException{
	
	
	// TODO Auto-generated method stub
	
	try {
		Class.forName(DRIVER);
		//System.out.println("Class.forName(DRIVER)");
			con = DriverManager.getConnection(URL,USER_ID,USER_PW);
			//System.out.println("DriverManager.getConnection(URL,USER_ID,USER_PW)");
			String query = "insert into Test_Board (id, name, content, post_date)"+"values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			//System.out.println("pstmt = con.prepareStatement(query)");
			
			pstmt.setString(1, id);
			 pstmt.setString(2, name);
			 pstmt.setString(3, ctt);
			 pstmt.setString(4, date);
			int resultNum = pstmt.executeUpdate();
			System.out.println("레코드가 " + resultNum + "개 저장되었습니다.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally {
			rs.close();
			pstmt.close();
			con.close();
		
		}
}




public static void delete(String id) throws SQLException {
	// 순서1 ~ 순서7 반복.
	// 순서1
	try {
		Class.forName(DRIVER);
		// 순서2
		con = DriverManager.getConnection(URL, USER_ID, USER_PW);

		// 순서3 , delete 부분으로 수정하기
		String query = "DELETE FROM Test_Board WHERE ID = ?";
		// 순서4, INSERT 시 동적인 데이터를 추가하는 세터 함수가 필요함.
		pstmt = con.prepareStatement(query);
		// VALUES(?,?,?), 첫번째 물음표를 1번으로 가리키고, 매개변수로 넘겨받은 데이터를 전달함.
		pstmt.setString(1, id);

		// 순서5
		int resultNum = pstmt.executeUpdate();
		System.out.println("레코드가 " + resultNum + "개 삭제되었습니다.");

		// 순서6, select 할 때 사용.
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		// 순서7, 자원반납, 사용의 역순 ,
		// 사용순서 1) con 2) pstmt 3) rs
		rs.close();
		pstmt.close();
		con.close();
	}
}

// update 는 id 제외하고, pwd , name 만 변경하기.



	public static void edit(String id,String name, String ctt, String date) throws SQLException{
	 
	 try {
		 Class.forName(DRIVER);
		 //명시된 드라이버 클래스를 메모리에 로딩한다. 
		 con = DriverManager.getConnection(URL, USER_ID, USER_PW); 
		 // DriverManager 클래스의 getConnection() 메소드를 이용해서
//		 Connection 객체를 얻는다. 
		 String sql = "UPDATE Test_Board SET name = ? , content = ?, post_date = ? WHERE id = ?";
		 //요청할 SQL  문을 String 변수에 저장한다. 이때 저장할 데이터 대신에 '?' 
		 //기호를 사용한다. 나중에 PreparedStatement 객체의 set()메소드를 
		 //사용하여 값을 동적으로 설정한다. 
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, name);
		 pstmt.setString(2, ctt);
		 pstmt.setString(3, date);
		 pstmt.setString(4, id);
		 //SQL 문 전송에 필요한 PreparedStatement 객체를 
		 //Connection 객체의 preparedStatement(sql)메소드를 이용해서 얻고 '?' 대신에 
		 //설정할 값을 인덱스(1부터 시작) 를 사용하여 set() 메소드로 설정한다.
	     int n = pstmt.executeUpdate();
	     // UPDATE 문을 요청하기 때문에 executeUpdate() 메소드를 
	     //사용하며 결과는 int 형으로 저장한다. 
	     System.out.println(n+"개의 레코드가 수정");
	     // 반환된 정수값을 출력하면 SQL 문을 실행한 뒤에 데이터베이스에 적용된 
	     // 레코드의 개수를 알수 있다. 
			 }catch(Exception e) {
		// e.printStackTrace();
	 }finally {
		 try {
			  if (pstmt != null) pstmt.close();
			 if ( con != null) con.close();
			 //사용한 자원을 finally 문을 이용해서 반납한다. 
			 // 자원 반납은 사용했던 객체의 역순으로 하며 모두 공통적으로 
			 // close()  메소드를 사용한다. 
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
}
	}
}
