package jdbcconnection;

/**
 * JDBC连接数据库
 * @author baofengWu
 * @version 1.0*    
 * 
 */

//STEP1. Import required packages
import java.sql.*;               //

public class jdbconnection {
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";          //Driver类 
	static final String DB_URL = "jdbc:mysql://localhost:3306/EMP";    //本机地址
	
	//Database credentials -- 数据库名和密码自己修改  
	static final String USER = "root";  // 
	static final String PASS = "wbf201696";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//STEP2. RegisterJDBC driver(注册JDBC应用程序(应用类),初始化驱动程序，这样就可以打开与数据库的通信)
			Class.forName("com.mysql.jdbc.Driver");  
			
			//STEP3. Open a connection(打开一个连接，代表数据库的物理连接)
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			
			//STEP4. Execute a query(需要使用一个类型为Statement或PreparedStatement的对象，并提交一个SQL语句到数据库执行查询)
			System.out.println("Create stament...");
			stmt = conn.createStatement();   //创建一个Statement对象，将SQL语句发送到数据库
			String sql;
			sql = "SELECT id, first, last, age FROM Employee";
			ResultSet rs = stmt.executeQuery(sql); //ResultSet对象保存Statement对象从数据库检索到的数据
			
			//STEP5. Extract data form result set(这一步骤演示如何从数据库中获取查询结果的数据)
			while(rs.next()) {
			//Retrieve(检索)by column name(通过列名来检索数据库)
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String first = rs.getString("first");
			String last = rs.getString("last");
			
			//Display values
			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);
			}
			
			//STEP6. Clean-up environment(清理环境资源)
			rs.close();
			stmt.close();
			conn.close();			
		}catch(SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally {
			System.out.println("finally块总是被执行！"); 
			//finally block used to close resources
			try {
				if(stmt != null)
					stmt.close();				
			}catch(SQLException se2) {
				//nothing we can do				
			}
			try {
				if(conn != null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main

}
