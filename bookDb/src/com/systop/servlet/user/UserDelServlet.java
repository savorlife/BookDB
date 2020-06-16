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


@WebServlet("/userDel")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		//实例化book对象
		User user = new User();
		//实例化
		UserDao typeDao = new UserDaoImpl();
		//调后台
		int i=typeDao.deletType(id1);
		//判断
				if (i > 0) {
					//跳页面
					request.getRequestDispatcher("/userList").forward(request, response);
				} else {
					//
					request.setAttribute("msg", "更新失败");
					//跳页面
					request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
