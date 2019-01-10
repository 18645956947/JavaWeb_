package javademo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* @author lenovo
* @date 2019年1月10日下午7:16:06 
* @Description: 
*/
public class LoginSuccess {
	public boolean LoginSuccess(String username, String password) throws Exception {
		boolean returnValue = false;
		String sql = "SELECT * FROM text";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
 
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				if (userName.equals(username) && passWord.equals(password)) {
					//如果用户名和密码都和数据库的一样，就返回true
					returnValue = true;
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;
 
	}
}
 