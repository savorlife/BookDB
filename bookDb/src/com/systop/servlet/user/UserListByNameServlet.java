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


@WebServlet("/userByName")
public class UserListByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String content = request.getParameter("content");
		String contrller = request.getParameter("contrller");
		int contrl=Integer.parseInt(contrller);
		
		//ʵ����
		UserDao typeDao = new UserDaoImpl();
		List<User> list =null;
		User user = new User();
		if(contrl==0) {
			//������
			list= typeDao.findTypeListByName(content);
			request.setAttribute("typeList", list);	
		}else if(contrl==1){
			int ID=Integer.parseInt(content);
			user = typeDao.findTypeByid(ID);
			request.setAttribute("user", user);	

		}else if(contrl==2){
			user = typeDao.findTypeByPhone(content);
			request.setAttribute("user", user);	
		}
		
		
		
		//��ҳ��
		request.getRequestDispatcher("/admin/userList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
