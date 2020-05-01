package com.systop.servlet;

import com.systop.entity.Admin;
import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7497140150886180490L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		String path=request.getContextPath();
		session.setAttribute("path", path);
		
			
			//解决中文乱码码问题
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("login/html;charset=UTF-8");
			//获取表单数据
			String adminName=request.getParameter("adminName");
			String adminPwd=request.getParameter("adminPwd");
			//调用后台方法登陆
			AdminDAO admindao=new AdminDAOimpl();
			Admin admin=admindao.loginAdmin(adminName,adminPwd);
			if(admin!=null){
				//成功
				session.setAttribute("admin",admin);
			      	Date time = new Date();
			      	SimpleDateFormat xizai = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			      	session.setAttribute("time",time);
			      	session.setAttribute("xizai",xizai);
				request.getRequestDispatcher("/index.jsp").forward(request, response); 
			}else{
				//失败
				
				request.setAttribute("cuo", "用户名或密码错误，请重新输入！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				//response.sendRedirect("/hagen_dazs/login.jsp"); // 重定向:跳转页面
			}
	}
	
	
}
