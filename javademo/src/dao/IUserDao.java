package dao;

import domain.User;

/** 
* @author lenovo
* @date 2019��1��14������3:02:05 
* @Description: 
*/
public interface IUserDao {
	public User loginUser(String username, String password);
}
 