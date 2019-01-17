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
* @date 2019年1月17日下午2:15:11 
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
				resp.getWriter().write("欢迎您" +userName);
			}else {
				long lastvisittime = Long.parseLong(cookie.getValue());
				resp.getWriter().write("欢迎您" +userName+" 您上次登陆的时间是"+new Date(lastvisittime));
				cookie.setValue(System.currentTimeMillis()+"");
				resp.addCookie(cookie);
				
			}
		}
		else {
			//重定向
			resp.sendRedirect("login_failed.jsp");
		}
		
//		//发送cookie给客户端
//		//默认关闭浏览器就失效 正值表示在这个时间后失效 负值是
//		cookie.setMaxAge(60*60*24);
//		cookie.setDomain(".example.com");
//		cookie.setPath("/demo");
//		resp.addCookie(cookie);
//		resp.getWriter().write("响应成功！！！");
//		
//		//获取客户端的cookie
//		Cookie[] cookies = req.getCookies();
//		if(cookie!=null) {
//			for (Cookie cookie2 : cookies) {
//				System.out.println(cookie2.getName() +"-----"+ cookie2.getValue());
//			}
//		}
		
	}
}
 