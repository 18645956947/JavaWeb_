package text;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

/** 
* @author lenovo
* @date 2019年1月15日下午2:39:33 
* @Description: 
*/
public class TextServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//以字符流方式向页面写数据  写中文会遇到中文问题
		//1。设置写出去的格式事UTF-8
		//2.设置在浏览器中看的格式是UTF-8
//		resp.setCharacterEncoding("UTF-8");
//		resp.setHeader("Content-Type", "text/html;chartset = UTF-8");
//		resp.getWriter().write("我是字符流输出");
		//以字节流方式向页面写数据
		/*
		 * 如果想要服务器出去的汉字 跟在浏览器看的数据一样的话 只需要保证 发出去的编码跟浏览器的编码一样
		 */
		//指定浏览器的编码
		//resp.setHeader("Content-Type", "text/html;chartset = UTF-8");
		resp.setContentType("text/html;chartset = UTF-8");
		resp.getOutputStream().write("你好".getBytes());
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username = " + username + "password = " + password);
	}
}
 