package text;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

/** 
* @author lenovo
* @date 2019��1��15������2:39:33 
* @Description: 
*/
public class TextServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ַ�����ʽ��ҳ��д����  д���Ļ�������������
		//1������д��ȥ�ĸ�ʽ��UTF-8
		//2.������������п��ĸ�ʽ��UTF-8
//		resp.setCharacterEncoding("UTF-8");
//		resp.setHeader("Content-Type", "text/html;chartset = UTF-8");
//		resp.getWriter().write("�����ַ������");
		//���ֽ�����ʽ��ҳ��д����
		/*
		 * �����Ҫ��������ȥ�ĺ��� �����������������һ���Ļ� ֻ��Ҫ��֤ ����ȥ�ı����������ı���һ��
		 */
		//ָ��������ı���
		//resp.setHeader("Content-Type", "text/html;chartset = UTF-8");
		
		resp.setContentType("text/html;chartset = UTF-8");
		//resp.getOutputStream().write("���".getBytes());
		
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		if("zhx".equals(userName)&&"123".equals(passWord)) {
			//����ת��
			req.getRequestDispatcher("login_success.jsp").forward(req, resp);;
		}
		else {
			//�ض���
			resp.sendRedirect("login_failed.jsp");
		}
		System.out.println("username = " + userName + "password = " + passWord);
	}
}
 