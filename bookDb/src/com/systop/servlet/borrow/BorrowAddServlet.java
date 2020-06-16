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

		//��ȡ����
		String bookid = request.getParameter("book_id");
		int book_id = Integer.parseInt(bookid);	
		String userid = request.getParameter("user_id");
		int user_id = Integer.parseInt(userid);

		//ʵ����ͼ������
		BookDao bookDao = new BookDaoImpl();
		Book book = new Book();
		//��ͼ����
		book = bookDao.findBookById(book_id);
		
		//ʵ�����û�����
		User user = new User();
		UserDao userDao = new UserDaoImpl();
		user = userDao.findTypeByid(user_id);
		//�ж�ͼ�����Ƿ�Ϊ0���û��������Ƿ�Ϊ0
		if(book.getKucun()!= 0 && user.getMax()!= 0) {
			//ͼ�����һ
			book.setKucun(book.getKucun()-1);
			int ku =bookDao.updateBook(book);
			
			//������-1�ɹ�
			if(ku>0) {
				
				user.setMax(user.getMax()-1);
				int max =userDao.updateType(user);
				//���������-1�ɹ�
				if(max>0) {
					//����ͼ�����
					String borrowdate = request.getParameter("borrow_date");
					java.util.Date borrow_date = null;
					if(borrowdate!=null&&!"".equals(borrowdate)) {
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//ע���·���MM
						try {
							borrow_date = simpleDateFormat.parse(borrowdate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					String type1 = request.getParameter("type");
					int type = Integer.parseInt(type1);	
				
					//ʵ����
					BorrowDao borrowDao = new BorrowDaoImpl();
					Borrow borrow = new Borrow();
					borrow.setBook_id(book_id);
					borrow.setUser_id(user_id);
					borrow.setBorrow_date(borrow_date);
					borrow.setOr_back(type);
					//����̨
					int row= borrowDao.AddBorrow(borrow);
					
					if(row>0) {
						request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
					}else {
						//�޸Ŀ����������
						request.setAttribute("msg", "����ͼ�����ʱ��������");
						request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
					}
				}else {
					//�޸Ŀ����������
					request.setAttribute("msg", "�����û����ʱ��������");
					request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
				}
				
				
				
			}else {
				//�޸Ŀ����������
				request.setAttribute("msg", "����ͼ������������");
				request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
			}
		}else if(book.getKucun() == 0){
			//
			request.setAttribute("msg", "ͼ����Ϊ0������ʧ��");
			request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "�û�����������þ�������ʧ��");
			request.getRequestDispatcher("/admin/bookAdd.jsp").forward(request, response);
		}
		

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
