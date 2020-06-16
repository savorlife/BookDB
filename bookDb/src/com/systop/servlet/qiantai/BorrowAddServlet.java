package com.systop.servlet.qiantai;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.systop.dao.BookDao;
import com.systop.dao.BorrowDao;
import com.systop.dao.UserDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.dao.impl.BorrowDaoImpl;
import com.systop.dao.impl.UserDaoImpl;
import com.systop.entity.Book;
import com.systop.entity.Borrow;
import com.systop.entity.User;



@WebServlet("/huiyuan/borrow")
public class BorrowAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡ����
		HttpSession session = request.getSession();
		User us = (User)session.getAttribute("user");
		int user_id = us.getU_id();
		String bookid = request.getParameter("id");
		int book_id = Integer.parseInt(bookid);	
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
					
					int type = 0;	
				
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
						request.setAttribute("y", "���ĳɳɹ����ɵ����ļ�¼�鿴����");
						request.getRequestDispatcher("/shumian").forward(request, response);
					}else {
						//�޸Ŀ����������
						request.setAttribute("y", "����ͼ�����ʱ��������");
						request.getRequestDispatcher("/shumian").forward(request, response);
					}
				}else {
					//�޸Ŀ����������
					request.setAttribute("y", "�����û����ʱ��������");
					request.getRequestDispatcher("/shumian").forward(request, response);
				}
				
			}else {
				//�޸Ŀ����������
				request.setAttribute("y", "����ͼ������������");
				request.getRequestDispatcher("/shumian").forward(request, response);
			}
		}else if(book.getKucun() == 0){
			//
			request.setAttribute("y", "ͼ����Ϊ0������ʧ��");
			request.getRequestDispatcher("/shumian").forward(request, response);
		}else {
			request.setAttribute("y", "����������þ�������ʧ��");
			request.getRequestDispatcher("/shumian").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
