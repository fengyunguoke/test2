package jdbcconnection;

/**
 * JDBC�������ݿ�
 * @author baofengWu
 * @version 1.0*    
 * 
 */

//STEP1. Import required packages
import java.sql.*;               //

public class jdbconnection {
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";          //Driver�� 
	static final String DB_URL = "jdbc:mysql://localhost:3306/EMP";    //������ַ
	
	//Database credentials -- ���ݿ����������Լ��޸�  
	static final String USER = "root";  // 
	static final String PASS = "wbf201696";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//STEP2. RegisterJDBC driver(ע��JDBCӦ�ó���(Ӧ����),��ʼ���������������Ϳ��Դ������ݿ��ͨ��)
			Class.forName("com.mysql.jdbc.Driver");  
			
			//STEP3. Open a connection(��һ�����ӣ��������ݿ����������)
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			
			//STEP4. Execute a query(��Ҫʹ��һ������ΪStatement��PreparedStatement�Ķ��󣬲��ύһ��SQL��䵽���ݿ�ִ�в�ѯ)
			System.out.println("Create stament...");
			stmt = conn.createStatement();   //����һ��Statement���󣬽�SQL��䷢�͵����ݿ�
			String sql;
			sql = "SELECT id, first, last, age FROM Employee";
			ResultSet rs = stmt.executeQuery(sql); //ResultSet���󱣴�Statement��������ݿ������������
			
			//STEP5. Extract data form result set(��һ������ʾ��δ����ݿ��л�ȡ��ѯ���������)
			while(rs.next()) {
			//Retrieve(����)by column name(ͨ���������������ݿ�)
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
			
			//STEP6. Clean-up environment(��������Դ)
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
			System.out.println("finally�����Ǳ�ִ�У�"); 
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
