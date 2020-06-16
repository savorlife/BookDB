package com.systop.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.UserDao;
import com.systop.dao.impl.UserDaoImpl;
import com.systop.entity.User;


@WebServlet("/userFindId")
public class UserFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取数据
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);	
		//实例化
		UserDao typeDao = new UserDaoImpl();
		//调后台
		User user = typeDao.findTypeByid(id1);
		//
		request.setAttribute("type", user);	
		//跳页面
		request.getRequestDispatcher("/admin/userUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
