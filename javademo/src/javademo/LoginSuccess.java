package javademo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* @author lenovo
* @date 2019��1��10������7:16:06 
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
					//����û��������붼�����ݿ��һ�����ͷ���true
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
 