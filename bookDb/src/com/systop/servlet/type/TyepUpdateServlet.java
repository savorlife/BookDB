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
		//��ȡ����
		String typeID = request.getParameter("typeID");
		int u_id1 = Integer.parseInt(typeID);
		
		String typeName = request.getParameter("typeName");
	
		//ʵ����book����
		Type type = new Type();
		
		type.setTypeID(u_id1);
		type.setTypeName(typeName);
		//ʵ����
		TypeDao typeDao = new TypeDaoImpl();
		//����̨
		int i = typeDao.updateType(type);
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
