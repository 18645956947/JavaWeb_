package service;

import domain.User;

/** 
* @author lenovo
* @date 2019年1月14日下午3:12:08 
* @Description: 
*/
public interface IUserService {
	public  User loginUser(String username,String password);
}
 