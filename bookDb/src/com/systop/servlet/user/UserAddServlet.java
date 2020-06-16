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


@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String uid = request.getParameter("u_id");
		int u_id = 0;
	
		String u_name = request.getParameter("u_name");
		String u_phone = request.getParameter("u_phone");
		String userpass = request.getParameter("userpass");
		String max1 = request.getParameter("max");
		int max = Integer.parseInt(max1);
		
		//ʵ����book����
		User user = new User();
		if(uid!=null&&!"".equals(uid)) {
			u_id = Integer.parseInt(uid);
			user.setU_id(u_id);
		}
		
		user.setU_name(u_name);
		user.setMax(max);
		user.setU_phone(u_phone);
		user.setUserpass(userpass);
		
		//ʵ����
		UserDao typeDao = new UserDaoImpl();
		//����̨
		int i = typeDao.addType(user);
		//�ж�

				if (i > 0) {
					//��ҳ��
					request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
				} else {
					//
					request.setAttribute("msg", "����ʧ��");
					//��ҳ��
					request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
