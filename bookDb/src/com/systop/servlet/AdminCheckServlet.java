package com.systop.servlet;

import com.systop.entity.Admin;
import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * 
 * 
 */
@WebServlet("/adminCheck")
public class AdminCheckServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4529365374982707772L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		this.doPost(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		String path=request.getContextPath();
		  //解决中文乱码码问题
	  	request.setCharacterEncoding("UTF-8");
	    //获取页面的值
	    String account= request.getParameter("account");
	    String adminpass= request.getParameter("adminpass");
	    String ty= request.getParameter("type");
	    int type=Integer.parseInt(ty);
	    //调用后台方法
	    AdminDAO admindao=new AdminDAOimpl();
	    Admin admin=new Admin();
	  	admin=admindao.adminCheck(account);
	    if(admin == null){
	    	//成功
	    	
	    	request.getRequestDispatcher("/adminAdd").forward(request,response);
	    }else{
	    	//失败
	    	request.setAttribute("chong", "账户重复");
	    	request.setAttribute("account", account);
	    	request.setAttribute("adminpass", adminpass);
	    	request.setAttribute("type", type);
	    	request.getRequestDispatcher("/adminAdd.jsp").forward(request,response);
	    }
	      
	}
	
}

