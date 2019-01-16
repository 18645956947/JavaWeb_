package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;

import org.apache.catalina.Loader;

import demo.DBConnection;

/** 
* @author lenovo
* @date 2019年1月14日下午1:22:03 
* @Description: 
*/
public class JdbcUtil {
	private static Properties properties  = new Properties ();
	// 设置成私有的
	private static final String DEIVER = "com.mysql.cj.jdbc.Driver";// 数据库驱�?
	private static final String URL = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC";//"mydatabase"是指你的数据库名�? 3306是端�?
	private static final String USERNAME = "root";//  数据库用户名                                 
	private static final String PASSWORD = "123456";//  数据库密�?
	private static Connection conn = null;//  连接对象
	// 静�?�代码块加载数据库驱�?
	static {
		/*
		 * try { ClassLoader Loader = Thread.currentThread().getContextClassLoader(); //
		 * 从classpath的跟路径去寻找db.properties InputStream inputStream =
		 * Loader.getResourceAsStream("db.properties"); properties.load(inputStream); }
		 * catch (IOException e) { throw new
		 * RuntimeException("加载classpath路径下的db.properties文件失败", e); }
		 */
		//1.加载注册驱动
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
	//5释放资源
	public static void close(Connection conn, Statement st, ResultSet re) {
		try {
			if (re != null) {
				re.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
 