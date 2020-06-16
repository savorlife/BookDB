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



@WebServlet("/borrowAdd")
public class BorrowAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取数据
		String bookid = request.getParameter("book_id");
		int book_id = Integer.parseInt(bookid);	
		String userid = request.getParameter("user_id");
		int user_id = Integer.parseInt(userid);

		//实例化图书类型
		BookDao bookDao = new BookDaoImpl();
		Book book = new Book();
		//查图书库存
		book = bookDao.findBookById(book_id);
		
		//实例化用户类型
		User user = new User();
		UserDao userDao = new UserDaoImpl();
		user = userDao.findTypeByid(user_id);
		//判断图书库存是否为0，用户借书量是否为0
		if(book.getKucun()!= 0 && user.getMax()!= 0) {
			//图书库存减一
			book.setKucun(book.getKucun()-1);
			int ku =bookDao.updateBook(book);
			
			//如果库存-1成功
			if(ku>0) {
				
				user.setMax(user.getMax()-1);
				int max =userDao.updateType(user);
				//如果借书量-1成功
				if(max>0) {
					//进行图书借阅
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
					String type1 = request.getParameter("type");
					int type = Integer.parseInt(type1);	
				
					//实例化
					BorrowDao borrowDao = new BorrowDaoImpl();
					Borrow borrow = new Borrow();
					borrow.setBook_id(book_id);
					borrow.setUser_id(user_id);
					borrow.setBorrow_date(borrow_date);
					borrow.setOr_back(type);
					//调后台
					int row= borrowDao.AddBorrow(borrow);
					
					if(row>0) {
						request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
					}else {
						//修改库存遇到问题
						request.setAttribute("msg", "处理图书借阅时遇到问题");
						request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
					}
				}else {
					//修改库存遇到问题
					request.setAttribute("msg", "更新用户库存时遇到问题");
					request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
				}
				
				
				
			}else {
				//修改库存遇到问题
				request.setAttribute("msg", "更新图书库存遇到问题");
				request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
			}
		}else if(book.getKucun() == 0){
			//
			request.setAttribute("msg", "图书库存为0，借阅失败");
			request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "用户借书次数已用尽，借阅失败");
			request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
		}
		

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
