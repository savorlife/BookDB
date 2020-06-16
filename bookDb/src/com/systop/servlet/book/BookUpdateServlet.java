package com.systop.servlet.book;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.util.UploadUtil;
import com.systop.dao.BookDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.entity.Book;


@WebServlet("/bookUpdate")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
	
		
		
//		UploadUtil uploadUtil = new UploadUtil();
        @SuppressWarnings("unchecked")
		HashMap<String,String> map= UploadUtil.upload(request);
        response.setContentType("text/html;charset=utf-8");

    	String id1 = map.get("id");
		int id = Integer.parseInt(id1);	
		String bookname = map.get("bookname");
		String img = map.get("img");
		String booktype1 = map.get("booktype");
		int booktype = Integer.parseInt(booktype1);
		String author = map.get("author");
		String publisher = map.get("publisher");
		String price1 = map.get("price");
		Double price = Double.valueOf(price1);
		String kucun1 = map.get("kucun");
		int kucun = Integer.parseInt(kucun1);
		String content = map.get("content");
		
		
		//实例化book对象
		Book book = new Book();
		book.setId(id);
		book.setBookname(bookname);
		book.setImg(img);
		book.setBooktype(booktype);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setKucun(kucun);
		book.setContent(content);
		
		//实例化
		BookDao bookDao = new BookDaoImpl();
		//调后台
		int row = bookDao.updateBook(book);
		//判断
		if(row>0) {
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
