package demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @author lenovo
* @date 2019年1月10日下午7:15:11 
* @Description: 
*/
public class loginServlet implements Servlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws Exception  {
		String username = request.getParameter("username");// 取得用户名
		String password = request.getParameter("password");// 取得密码
		System.out.println("取得用户名和密码");
		 
		LoginSuccess db = new LoginSuccess(); // 构建登陆对象
		boolean canLogin = db.LoginSuccess(username, password);// 取得用户名和密码
		if (canLogin) {// 根据登陆情况，跳转页面
			System.out.println("用户名和密码正确");
			response.sendRedirect("login_success.jsp");
		} else {
			response.sendRedirect("login_failed.jsp");
			System.out.println("用户名和密码错误");
		}
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		try {
			doPost(rq, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 