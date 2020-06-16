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


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		//获取数据
		HttpSession session = request.getSession();
		User us = (User)session.getAttribute("user");
		String juserpass = request.getParameter("juserpass");
		String pass = us.getUserpass();
		if(juserpass != pass) {
			
		
		
		
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
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("/huiyuan/mine").forward(request, response);
		} else {

			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("/huiyuan/mine").forward(request, response);
		}
		}else {
			request.setAttribute("msg", "密码错误");
			request.getRequestDispatcher("/huiyuan/mine").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
