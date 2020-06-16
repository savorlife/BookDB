package com.systop.servlet.type;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.TypeDao;
import com.systop.dao.impl.TypeDaoImpl;


@WebServlet("/typeDel")
public class TyepDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		//ʵ����
		TypeDao typeDao = new TypeDaoImpl();
		//����̨
		int i=typeDao.deletType(id1);
		//�ж�
				if (i > 0) {
					//��ҳ��
					request.getRequestDispatcher("/typeList").forward(request, response);
				} else {
					//
					request.setAttribute("msg", "����ʧ��");
					//��ҳ��
					request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
