package dao;

import domain.User;

/** 
* @author lenovo
* @date 2019年1月14日下午3:02:05 
* @Description: 
*/
public interface IUserDao {
	public User loginUser(String username, String password);
}
 