package com.systop.servlet.borrow;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BorrowDao;

import com.systop.dao.impl.BorrowDaoImpl;

import com.systop.entity.Borrow;



@WebServlet("/borrowById")
public class BorrowFindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡ����
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);	
		String all = request.getParameter("all");

		//ʵ����
		Borrow borrow = new Borrow();
		BorrowDao borrowDao = new BorrowDaoImpl();
		//����̨
		borrow= borrowDao.findBorrowById(id);
	
		request.setAttribute("borrow", borrow);	
		//��ҳ��
		if(all != null&&!"".equals(all)) {
			request.setAttribute("all", 1);	
		}
		request.getRequestDispatcher("/admin/borrowUpdate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
