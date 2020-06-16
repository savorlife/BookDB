package com.systop.servlet.type;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.TypeDao;
import com.systop.dao.impl.TypeDaoImpl;
import com.systop.entity.Type;


@WebServlet("/typeList")
public class TypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String typeName = request.getParameter("typeName");
		//实例化
		TypeDao typeDao = new TypeDaoImpl();
		//调后台
		List<Type> list= typeDao.findTypeAll(typeName);
		//
		request.setAttribute("typeList", list);	
		//跳页面
		request.getRequestDispatcher("/admin/typeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
