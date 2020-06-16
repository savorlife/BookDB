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
		//获取数据
		String u_id = request.getParameter("u_id");
		int u_id1 = Integer.parseInt(u_id);
		
		String u_name = request.getParameter("u_name");
		String u_phone = request.getParameter("u_phone");
		String max1 = request.getParameter("max");
		int max = Integer.parseInt(max1);
		String userpass = request.getParameter("userpass");
		//实例化book对象
		User user = new User();
		
		user.setU_id(u_id1);
		user.setU_name(u_name);
		user.setU_phone(u_phone);
		user.setMax(max);
		user.setUserpass(userpass);
		//实例化
		UserDao typeDao = new UserDaoImpl();
		//调后台
		int i = typeDao.updateType(user);
		//判断
		if (i > 0) {
			//跳页面
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {
			//
//			request.setAttribute("msg", "更新失败");
			//跳页面
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
