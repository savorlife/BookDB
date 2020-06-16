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
		  //�����������������
	  	request.setCharacterEncoding("UTF-8");
	    //��ȡҳ���ֵ
	  	
	    //��ȡҳ���ֵ
	    String bookid= request.getParameter("book_id");
	    int book_id = 0;
	    Book book =  new Book();
	    book =null;
	    if(bookid!=null&&!"".equals(bookid)) {
	    	book_id = Integer.parseInt(bookid);	
	    	BookDao bookdao =  new BookDaoImpl();
	    	book =bookdao.findBookById(book_id);
	    	 PrintWriter out = response.getWriter();
	 		//�жϽ��
	 		if (book!= null) {
	 			//����д������򷵻�0
	 			out.write(book.getBookname());
	 			
	 		} else {
	 			//����޴������򷵻�1
	 			out.write("��Ч���");
	 		}
	 		out.close();
	    }
	  	
	
	}

}
