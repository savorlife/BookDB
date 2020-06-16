package com.systop.servlet.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.systop.dao.BookDao;
import com.systop.dao.TypeDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.dao.impl.TypeDaoImpl;
import com.systop.entity.Book;
import com.systop.entity.Type;


@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id1 = request.getParameter("book_id");
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
		
		TypeDao typedao =new TypeDaoImpl();
		String typeName = null;
		List<Type> typelist = typedao.findTypeAll(typeName);
		//
		HttpSession session = request.getSession();
		session.setAttribute("bookList", list);	
		session.setAttribute("typelist", typelist);
		//跳页面
		request.getRequestDispatcher("/admin/bookList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
