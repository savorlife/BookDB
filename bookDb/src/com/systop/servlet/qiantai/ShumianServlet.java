package com.systop.servlet.qiantai;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BookDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.entity.Book;


@WebServlet("/shumian")
public class ShumianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		

		String id1 = request.getParameter("id");
		int book_id = 0;
		if(id1!=null&&!"".equals(id1)) {
			book_id= Integer.parseInt(id1);	
		}
		String author = request.getParameter("author");
		String bookname = request.getParameter("bookname");
		String publisher = request.getParameter("publisher");
	
		String type1 = request.getParameter("type");
		int type = -1;
		if(type1!=null&&!"".equals(type1)) {
			type= Integer.parseInt(type1);	
		}
		
		
		//实例化
		BookDao bookDao = new BookDaoImpl();
		//调后台
		
		List<Book> list= bookDao.findBookAll(book_id,author,type,publisher,bookname);
		
		//
		request.setAttribute("book", list);	
		//跳页面
		request.getRequestDispatcher("/shumian.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
