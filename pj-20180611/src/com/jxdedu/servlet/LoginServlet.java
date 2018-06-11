package com.jxdedu.servlet;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {



	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.getRequestDispatcher("test/ShowString.jsp").forward(request, response);
//	}

	private void preLogin(HttpSession session){
		// 移除登录标志; 与登录成功时设置的登录标志对应;
		session.removeAttribute("loginFlag");
	}
	
	/**
	 * 登录成功后的信息设置;
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void postLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取用户名和密码
		String loginName = request.getParameter("loginUserName");
		String loginPwd  = request.getParameter("loginPassword");
		
		HttpSession session = request.getSession();
		
		
		// 登录名和日期
		//在欢迎页面需要管理员的名字，后台需要存放一下
		session.setAttribute("userName", loginName);
//		//在欢迎页面需要管理员的登录时间，后台需要把当前登录时间存到request中
//		Date date = new Date();//利用当前时间创建日期对象
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String loginTime = sf.format(date);
		//把时间存到请求中
//		session.setAttribute("loginTime", loginTime);

		// 移除登录失败的提示信息, 与登录失败时设置的提示信息对应;
		session.removeAttribute("msg");
	}
	
	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		// 获取用户名和密码
		String loginName = request.getParameter("loginUserName");
		String loginPwd  = request.getParameter("loginPassword");
		
		HttpSession session = request.getSession();
		
		// 初始化与登录控制相关的信息
		preLogin(session);
		
		
		if (isValid(loginName, loginPwd)){

			// 登录成功,设置相关标志信息和欢迎信息
			postLogin(request, response);
			
			request.getRequestDispatcher("index.jsp").forward(request,response);
			
		}else{
			
			request.getSession().setAttribute("msg","用户名或密码错误");
			response.sendRedirect("login.jsp");
		}
		
	}
	
	boolean isValid(String name,String pwd){
	    return "abc".equals(name) && "123".equals(pwd);
	}


}
