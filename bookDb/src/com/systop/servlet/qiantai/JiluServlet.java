package com.systop.servlet.qiantai;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.systop.dao.BorrowDao;
import com.systop.dao.impl.BorrowDaoImpl;
import com.systop.entity.Borrow;
import com.systop.entity.User;


@WebServlet("/huiyuan/jilu")
public class JiluServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		int u_id = user.getU_id();
//		
//		String id1 = request.getParameter("u_id");
//		int u_id = 0;
//		if(id1!=null&&!"".equals(id1)) {
//			u_id= Integer.parseInt(id1);	
//		}
		String type1 = request.getParameter("type");
		int type = -1;
		if(type1!=null&&!"".equals(type1)) {
			type= Integer.parseInt(type1);	
		}
		String book = request.getParameter("book_id");
		int book_id = 0;
		if(book!=null&&!"".equals(book)) {
			book_id= Integer.parseInt(book);	
		}
		
		
		//ʵ����
		BorrowDao borrow = new BorrowDaoImpl();
		//����̨
		List<Borrow> list= borrow.findBorrowAllBy(book_id,u_id,type);
		//
		request.setAttribute("borrowList", list);	
		
		//��ҳ��
		request.getRequestDispatcher("/huiyuan/jilu.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
