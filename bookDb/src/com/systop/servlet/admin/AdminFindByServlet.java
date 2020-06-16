package com.systop.servlet.admin;

import com.systop.entity.Admin;
import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 */
@WebServlet("/adminFindBy")
public class AdminFindByServlet extends HttpServlet{
	
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
	  //获取数据
	  		String content = request.getParameter("content");
	  		
	  		
	  		 //调用后台方法
		    AdminDAO admindao=new AdminDAOimpl();
		    Admin admin=new Admin();
		    List<Admin> list=null; 
	  		
	  		

				//查名字
				list= admindao.adminFindByAccount(content);
				request.setAttribute("list", list);

	   if(admin!=null||list!=null){
	    	//成功
	    	request.getRequestDispatcher("/admin/adminlist.jsp").forward(request,response);
	   }else{
	    	//失败
	    	request.getRequestDispatcher("/admin/error.jsp").forward(request,response);
	    }
	      
	}
	
}

