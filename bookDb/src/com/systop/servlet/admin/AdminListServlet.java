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
import javax.servlet.http.HttpSession;


/**
 * 
 * 
 */
@WebServlet("/adminList")
public class AdminListServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7165903369338239111L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		this.doPost(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		String path=request.getContextPath();
		
		int pageNow;
		String pN=request.getParameter("pageNow");
		
		if(pN==null) {
			pN="1";
			pageNow=Integer.parseInt(pN);
		}else {
			pageNow=Integer.parseInt(pN);
		}
		
		
	      //实例化操作对象
	     AdminDAO admindao=new AdminDAOimpl();
	   	List<Admin> list = admindao.findAdminAll(pageNow);//查询列表
	   	int pages=admindao.pages();
	   	
	   	HttpSession session = request.getSession();
	   	session.setAttribute("list", list);
	   	
	   	if(pageNow<=0||pageNow>pages) {
	   		session.setAttribute("pageNow", "1");
	   	}else{
	   		session.setAttribute("pageNow", pageNow);
	   	}
	   	session.setAttribute("pages", pages);
	   
	   	request.getRequestDispatcher("/admin/adminlist.jsp").forward(request, response);
	   	
	}
	
	
}
