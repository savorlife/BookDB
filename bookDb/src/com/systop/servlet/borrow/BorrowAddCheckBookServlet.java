package com.systop.servlet.borrow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BookDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.entity.Book;

/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/borrowCheckBook")
public class BorrowAddCheckBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BorrowAddCheckBookServlet() {
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
	  	
	    //获取页面的值
	    String bookid= request.getParameter("book_id");
	    int book_id = 0;
	    Book book =  new Book();
	    book =null;
	    if(bookid!=null&&!"".equals(bookid)) {
	    	book_id = Integer.parseInt(bookid);	
	    	BookDao bookdao =  new BookDaoImpl();
	    	book =bookdao.findBookById(book_id);
	    	 PrintWriter out = response.getWriter();
	 		//判断结果
	 		if (book!= null) {
	 			//如果有此数据则返回0
	 			out.write(book.getBookname());
	 			
	 		} else {
	 			//如果无此数据则返回1
	 			out.write("无效编号");
	 		}
	 		out.close();
	    }
	  	
	
	}

}
