package com.systop.servlet.qiantai;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.systop.dao.UserDao;
import com.systop.dao.impl.UserDaoImpl;
import com.systop.entity.User;


@WebServlet("/zhuce")
public class ZhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String uid = request.getParameter("u_id");
		
		String u_name = request.getParameter("u_name");
		String u_phone = request.getParameter("u_phone");
		String userpass = request.getParameter("userpass");
		int max = 3;
		
		//ʵ����book����
		User user1 = new User();
		if(uid!=null&&!"".equals(uid)) {
			int u_id = Integer.parseInt(uid);
			user1.setU_id(u_id);
		}
		user1.setU_name(u_name);
		user1.setMax(max);
		user1.setU_phone(u_phone);
		user1.setUserpass(userpass);
		
		//ʵ����
		UserDao typeDao = new UserDaoImpl();
		//����̨
		int i = typeDao.addType(user1);
		//�ж�

				if (i > 0) {
					//��ҳ��
					HttpSession session = request.getSession();
					session.setAttribute("user", user1);
					request.getRequestDispatcher("/huiyuan/mine").forward(request, response);
				} else {
					//
					request.setAttribute("msg", "ע��ʧ��");
					//��ҳ��
					request.getRequestDispatcher("/zhuce.jsp").forward(request, response);
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
