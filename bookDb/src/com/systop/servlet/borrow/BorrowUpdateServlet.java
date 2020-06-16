package com.systop.servlet.borrow;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BookDao;
import com.systop.dao.BorrowDao;
import com.systop.dao.UserDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.dao.impl.BorrowDaoImpl;
import com.systop.dao.impl.UserDaoImpl;
import com.systop.entity.Book;
import com.systop.entity.Borrow;
import com.systop.entity.User;




@WebServlet("/borrowUpdate")
public class BorrowUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取数据
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);	
		
		String bookid = request.getParameter("book_id");
		int book_id = Integer.parseInt(bookid);	
		String userid = request.getParameter("user_id");
		int user_id = Integer.parseInt(userid);
		
		String borrowdate = request.getParameter("borrow_date");
		java.util.Date borrow_date = null;
		if(borrowdate!=null&&!"".equals(borrowdate)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
			try {
				borrow_date = simpleDateFormat.parse(borrowdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
        String backdate = request.getParameter("back_date");
        java.util.Date back_date = null;
        if(backdate!=null&&!"".equals(backdate)) {
        	SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        	try {
    			back_date = simpleDateFormat1.parse(backdate);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
        
        }
		
		
		
		String type1 = request.getParameter("type");
		int type = Integer.parseInt(type1);	
		
		
		//实例化
		BorrowDao borrowDao = new BorrowDaoImpl();
		Borrow borrow = new Borrow();
		borrow.setId(id);
		borrow.setBook_id(book_id);
		borrow.setUser_id(user_id);
		borrow.setBorrow_date(borrow_date);
		borrow.setBack_date(back_date);
		borrow.setOr_back(type);
		//调后台
		int row= borrowDao.updateBorrowAll(borrow);
		
		if(row>0) {
			//如果是已还
			if(type == 2) {
				//对图书库存和用户可借进行+1
			
			//实例化图书类型
			BookDao bookDao = new BookDaoImpl();
			Book book = new Book();
			//查图书库存
			book = bookDao.findBookById(book_id);
			book.setKucun(book.getKucun()+1);
			int ku =bookDao.updateBook(book);
			if(ku<=0) {
				request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
			}
			
			//实例化用户类型
			User user = new User();
			UserDao userDao = new UserDaoImpl();
			user = userDao.findTypeByid(user_id);
			user.setMax(user.getMax()+1);
			int max =userDao.updateType(user);
			if(max<=0) {
				request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
			}
			
			}else {
				request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
			}
			
		}else {
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
