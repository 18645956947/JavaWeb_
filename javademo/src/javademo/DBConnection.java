package javademo;

import java.sql.Connection;
import java.sql.DriverManager;

/** 
* @author lenovo
* @date 2019年1月10日下午7:10:56 
* @Description: 
*/
public class DBConnection {
	// 设置成私有的
	private static final String DEIVER = "com.mysql.cj.jdbc.Driver";// 数据库驱动
	private static final String URL = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC";//"mydatabase"是指你的数据库名称 3306是端口
	private static final String USERNAME = "root";//  数据库用户名                                 
	private static final String PASSWORD = "123456";//  数据库密码
	private static Connection conn = null;//  连接对象
	// 静态代码块加载数据库驱动
	static {
		try {
			Class.forName(DEIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	// 单例模式返回数据库连接对象
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
				System.out.println("数据库连接正常");
			} else {
				System.out.println("数据库连接异常");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 