package com.systop.servlet.user;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.UserDao;
import com.systop.dao.impl.UserDaoImpl;
import com.systop.entity.User;


@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String u_id = request.getParameter("u_id");
		int u_id1 = Integer.parseInt(u_id);
		
		String u_name = request.getParameter("u_name");
		String u_phone = request.getParameter("u_phone");
		String max1 = request.getParameter("max");
		int max = Integer.parseInt(max1);
		String userpass = request.getParameter("userpass");
		//ʵ����book����
		User user = new User();
		
		user.setU_id(u_id1);
		user.setU_name(u_name);
		user.setU_phone(u_phone);
		user.setMax(max);
		user.setUserpass(userpass);
		//ʵ����
		UserDao typeDao = new UserDaoImpl();
		//����̨
		int i = typeDao.updateType(user);
		//�ж�
		if (i > 0) {
			//��ҳ��
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {
			//
//			request.setAttribute("msg", "����ʧ��");
			//��ҳ��
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
