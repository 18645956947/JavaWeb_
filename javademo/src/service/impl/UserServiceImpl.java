package service.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.IUserService;

/** 
* @author lenovo
* @date 2019年1月14日下午3:12:58 
* @Description: 
*/
public class UserServiceImpl implements IUserService{
	private IUserDao dao = new UserDaoImpl();
	@Override
	public User loginUser(String username, String password) {
		return dao.loginUser(username, password);
	}
}
 