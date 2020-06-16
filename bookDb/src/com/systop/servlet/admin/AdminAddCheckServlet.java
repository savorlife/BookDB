package com.systop.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;
import com.systop.entity.Admin;

/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/adminCheck")
public class AdminAddCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddCheckServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path=request.getContextPath();
		  //�����������������
	  	request.setCharacterEncoding("UTF-8");
	    //��ȡҳ���ֵ
	    String account= request.getParameter("L_account");
	    //���ú�̨����
	    AdminDAO admindao=new AdminDAOimpl();
	    Admin admin=new Admin();
	  	admin=admindao.adminCheck(account);
	    PrintWriter out = response.getWriter();
		//�жϽ��
		if (admin!= null) {
			//����д������򷵻�0
			out.write("0");
		} else {
			//����޴������򷵻�1
			out.write("1");
		}
		out.close();
	}

}
