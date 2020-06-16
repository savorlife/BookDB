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


@WebServlet("/huiyuan/mine")
public class MineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取数据
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		int u_id = user.getU_id();
		
		//实例化
		UserDao typeDao = new UserDaoImpl();
		//调后台
		user = typeDao.findTypeByid(u_id);
		//
		session.setAttribute("user", user);	
		//跳页面
		request.getRequestDispatcher("/huiyuan/mine.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
