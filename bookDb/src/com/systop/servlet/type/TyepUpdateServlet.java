package com.systop.servlet.type;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.TypeDao;
import com.systop.dao.impl.TypeDaoImpl;
import com.systop.entity.Type;


@WebServlet("/typeUpdate")
public class TyepUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		String typeID = request.getParameter("typeID");
		int u_id1 = Integer.parseInt(typeID);
		
		String typeName = request.getParameter("typeName");
	
		//实例化book对象
		Type type = new Type();
		
		type.setTypeID(u_id1);
		type.setTypeName(typeName);
		//实例化
		TypeDao typeDao = new TypeDaoImpl();
		//调后台
		int i = typeDao.updateType(type);
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
