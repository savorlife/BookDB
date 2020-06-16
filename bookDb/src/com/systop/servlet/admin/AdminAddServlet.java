package com.systop.servlet.admin;

import java.io.IOException;
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
@WebServlet("/adminAdd")
public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddServlet() {
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
	    String account= request.getParameter("account");
	    String adminpass =request.getParameter("adminpass");
	    String ty =request.getParameter("type");
	    int type=Integer.parseInt(ty);
	    //ʵ����Admin����
	    Admin admin=new Admin();
	    admin.setAccount(account);
	    admin.setAdminpass(adminpass);
	    admin.setType(type);
	    //���ú�̨����
	    AdminDAO admindao=new AdminDAOimpl();
	    int rows= admindao.saveAdmin(admin);
	    if(rows>0){
	    	//�ɹ�
	    	request.getRequestDispatcher("/admin/success.jsp").forward(request,response);
	    }else{
	    	//ʧ��
	    	request.getRequestDispatcher("/admin/error.jsp").forward(request,response);
	    }
	}

}
