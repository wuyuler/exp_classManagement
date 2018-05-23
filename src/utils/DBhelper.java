package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DBhelper {
	private static final String driver = "org.postgresql.Driver";
	private static final String url ="jdbc:postgresql://localhost:5432/example";
	private static final String username = "postgres";
	private static final String password = "admin";
	private static Connection cnn = null;
	
	//静态代码加载驱动
	static {
		try {
			
			Class.forName(driver);
		}
			catch (Exception e) {
				
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
	}
	//单例模式创建数据库连接
	public static Connection getConnection() throws SQLException {
		if(cnn==null) {
			cnn = DriverManager.getConnection(url, username, password);
			return cnn;
		}
		else return cnn;
	}
// 测试数据库连接
	public static void main(String[] args) {
		try {
			Connection con = DBhelper.getConnection();
			if(cnn!=null) System.out.println("链接正常");
			else System.out.println("连接失败");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	
	
	
	
}
