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
* @date 2019��1��10������7:15:11 
* @Description: 
*/
public class loginServlet implements Servlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws Exception  {
		String username = request.getParameter("username");// ȡ���û���
		String password = request.getParameter("password");// ȡ������
		System.out.println("ȡ���û���������");
		 
		LoginSuccess db = new LoginSuccess(); // ������½����
		boolean canLogin = db.LoginSuccess(username, password);// ȡ���û���������
		if (canLogin) {// ���ݵ�½�������תҳ��
			System.out.println("�û�����������ȷ");
			response.sendRedirect("login_success.jsp");
		} else {
			response.sendRedirect("login_failed.jsp");
			System.out.println("�û������������");
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
 