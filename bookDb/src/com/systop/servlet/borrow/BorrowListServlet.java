package com.systop.servlet.borrow;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BorrowDao;
import com.systop.dao.impl.BorrowDaoImpl;
import com.systop.entity.Borrow;


@WebServlet("/borrowList")
public class BorrowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id1 = request.getParameter("u_id");
		int u_id = 0;
		if(id1!=null&&!"".equals(id1)) {
			u_id= Integer.parseInt(id1);	
		}
		String type1 = request.getParameter("type");
		int type = -1;
		if(type1!=null&&!"".equals(type1)) {
			type= Integer.parseInt(type1);	
		}
		String book = request.getParameter("book_id");
		int book_id = 0;
		if(book!=null&&!"".equals(book)) {
			book_id= Integer.parseInt(book);	
		}
		
		
		//实例化
		BorrowDao borrow = new BorrowDaoImpl();
		//调后台
		List<Borrow> list= borrow.findBorrowAllBy(book_id,u_id,type);
		//
		request.setAttribute("borrowList", list);	
		
		//跳页面
		request.getRequestDispatcher("/admin/borrowList.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
