package text;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookieutil.CookieUtil;

/** 
* @author lenovo
* @date 2019��1��17������2:15:11 
* @Description: 
*/
public class TextCookieServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		if("zhx".equals(userName)&&"123".equals(passWord)) {
			Cookie[] cookies = req.getCookies();
			Cookie cookie = CookieUtil.findCookie(cookies, "last");
			if(cookie==null) {
				Cookie c = new Cookie("last", System.currentTimeMillis()+"");
				c.setMaxAge(60*60*24);
				resp.addCookie(c);
				resp.getWriter().write("��ӭ��" +userName);
			}else {
				long lastvisittime = Long.parseLong(cookie.getValue());
				resp.getWriter().write("��ӭ��" +userName+" ���ϴε�½��ʱ����"+new Date(lastvisittime));
				cookie.setValue(System.currentTimeMillis()+"");
				resp.addCookie(cookie);
				
			}
		}
		else {
			//�ض���
			resp.sendRedirect("login_failed.jsp");
		}
		
//		//����cookie���ͻ���
//		//Ĭ�Ϲر��������ʧЧ ��ֵ��ʾ�����ʱ���ʧЧ ��ֵ��
//		cookie.setMaxAge(60*60*24);
//		cookie.setDomain(".example.com");
//		cookie.setPath("/demo");
//		resp.addCookie(cookie);
//		resp.getWriter().write("��Ӧ�ɹ�������");
//		
//		//��ȡ�ͻ��˵�cookie
//		Cookie[] cookies = req.getCookies();
//		if(cookie!=null) {
//			for (Cookie cookie2 : cookies) {
//				System.out.println(cookie2.getName() +"-----"+ cookie2.getValue());
//			}
//		}
		
	}
}
 