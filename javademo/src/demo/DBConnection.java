package demo;

import java.sql.Connection;
import java.sql.DriverManager;

/** 
* @author lenovo
* @date 2019�?1�?10日下�?7:10:56 
* @Description: 
*/
public class DBConnection {
	// 设置成私有的
	private static final String DEIVER = "com.mysql.cj.jdbc.Driver";// 数据库驱�?
	private static final String URL = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC";//"mydatabase"是指你的数据库名�? 3306是端�?
	private static final String USERNAME = "root";//  数据库用户名                                 
	private static final String PASSWORD = "123456";//  数据库密�?
	private static Connection conn = null;//  连接对象
	// 静�?�代码块加载数据库驱�?
	static {
		try {
			Class.forName(DEIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	// 单例模式返回数据库连接对�?
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conn;
		}
		return conn;
	}
 
	public static void main(String[] args) {
		try {
			Connection conn = DBConnection.getConnection();
			if (conn != null) {
				System.out.println("数据库连接正�?");
			} else {
				System.out.println("数据库连接异�?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 