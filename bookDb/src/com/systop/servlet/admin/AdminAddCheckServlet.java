package com.systop.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;
import com.systop.entity.Admin;

/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/adminCheck")
public class AdminAddCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddCheckServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path=request.getContextPath();
		  //解决中文乱码码问题
	  	request.setCharacterEncoding("UTF-8");
	    //获取页面的值
	    String account= request.getParameter("L_account");
	    //调用后台方法
	    AdminDAO admindao=new AdminDAOimpl();
	    Admin admin=new Admin();
	  	admin=admindao.adminCheck(account);
	    PrintWriter out = response.getWriter();
		//判断结果
		if (admin!= null) {
			//如果有此数据则返回0
			out.write("0");
		} else {
			//如果无此数据则返回1
			out.write("1");
		}
		out.close();
	}

}
