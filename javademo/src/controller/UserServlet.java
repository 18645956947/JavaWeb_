package controller;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.IUserService;
import service.impl.UserServiceImpl;

/** 
* @author lenovo
* @date 2019年1月14日下午3:15:36 
* @Description: 
*/
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		/*
		 * Map<String, String[]>map = req.getParameterMap(); Iterable<T> iterable =
		 * map.keySet(); while (iterable.hasNext()) { type type = (type)
		 * iterable.next();
		 * 
		 * }
		 */
		User user = userService.loginUser(userName, password);
		if (user != null) {
			resp.sendRedirect("login_success.jsp");
		}else {
			resp.sendRedirect("login_failed.jsp");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
 