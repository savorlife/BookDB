package com.systop.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BookDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.entity.Book;


@WebServlet("/findBookById")
public class BookFindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡ����
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);	
		//ʵ����
		BookDao bookDao = new BookDaoImpl();
		//����̨
		Book book = bookDao.findBookById(id1);
		//
		request.setAttribute("book", book);	
		//��ҳ��
		request.getRequestDispatcher("/admin/bookUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
