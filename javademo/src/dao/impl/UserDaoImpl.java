package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.IUserDao;
import domain.User;
import util.JdbcUtil;

/** 
* @author lenovo
* @date 2019年1月14日下午3:04:56 
* @Description: 
*/
public class UserDaoImpl implements IUserDao{
	@Override
	public User loginUser(String username,String password) {
		String sql = "SELECT * FROM text WHERE username=? AND password=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
 