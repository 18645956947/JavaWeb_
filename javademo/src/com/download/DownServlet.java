package com.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileNameExtensionFilter;

/** 
* @author lenovo
* @date 2019年1月15日下午4:25:15 
* @Description: 
*/
public class DownServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("filename");
		fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("fileName="+fileName);
		//获取在tomcat的绝对路径
		String path = getServletContext().getRealPath("DownServlet/" + fileName);
		//让浏览器收到资源的时候以弹窗提醒用户
		resp.setHeader("Content-Disposition", "attachment; fileName="+fileName);
		//3.转换输入流
		InputStream is = new FileInputStream(fileName);
		OutputStream os = resp.getOutputStream();
		int len = 0;
		byte[]buffer =  new byte[1024];
		while((len=is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
 