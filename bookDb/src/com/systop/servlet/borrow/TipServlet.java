package com.systop.servlet.borrow;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BorrowDao;

import com.systop.dao.impl.BorrowDaoImpl;

import com.systop.entity.Borrow;


/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/tip")
public class TipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TipServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path=request.getContextPath();
		  //解决中文乱码码问题
	  	request.setCharacterEncoding("UTF-8");
	  	
	  	BorrowDao borrow = new BorrowDaoImpl();
		
		int idC =0;
		int typeC = 0;
		int book_idC =0;
		List<Borrow> listC= borrow.findBorrowAllBy(book_idC,idC,typeC);
		PrintWriter out = response.getWriter();
		 if(listC.size() != 0) {
			 out.write("1");
		}else {
			 out.write("0");
		} 	
	
	}

}
