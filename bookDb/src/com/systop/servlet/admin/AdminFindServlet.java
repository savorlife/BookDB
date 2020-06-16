package com.systop.servlet.admin;

import com.systop.entity.Admin;
import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 */
@WebServlet("/adminFind")
public class AdminFindServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2602234764121542212L;

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
	    String id= request.getParameter("id");
		int aid=Integer.parseInt(id);
	    //调用后台方法
	    AdminDAO admindao=new AdminDAOimpl();
	    Admin admin=new Admin();
	  	admin=admindao.findAdminId(aid);
	    if(admin!=null){
	    	//成功
	    	request.setAttribute("admin", admin);
	    	request.getRequestDispatcher("/admin/adminUpdate.jsp").forward(request,response);
	    }else{
	    	//失败
	    	request.getRequestDispatcher("/admin/error.jsp").forward(request,response);
	    }
	      
	}
	
}

