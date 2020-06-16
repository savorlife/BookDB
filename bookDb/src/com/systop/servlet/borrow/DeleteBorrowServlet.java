package com.systop.servlet.borrow;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BorrowDao;

import com.systop.dao.impl.BorrowDaoImpl;




@WebServlet("/borrowDelete")
public class DeleteBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取数据
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);	
		//实例化
		BorrowDao borrowDao = new BorrowDaoImpl();
		//调后台
		int row= borrowDao.deleteBorrow(id);
		
		if(row>0) {
			request.getRequestDispatcher("/borrowList").forward(request, response);
		}else {
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
