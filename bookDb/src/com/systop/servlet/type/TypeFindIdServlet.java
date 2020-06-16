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


@WebServlet("/typeFindId")
public class TypeFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡ����
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);	
		//ʵ����
		TypeDao typeDao = new TypeDaoImpl();
		//����̨
		Type Type = typeDao.findTypeByid(id1);
		//
		request.setAttribute("type", Type);	
		//��ҳ��
		request.getRequestDispatcher("/admin/typeUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
