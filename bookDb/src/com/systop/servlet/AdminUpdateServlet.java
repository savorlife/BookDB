package com.systop.servlet;

import com.systop.entity.Admin;
import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 */
@WebServlet("/adminUpdate")
public class AdminUpdateServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8242486051553747296L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		this.doPost(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		String path=request.getContextPath();
			
		  //�����������������
	  	request.setCharacterEncoding("UTF-8");
	    //��ȡҳ���ֵ
	    String a_id= request.getParameter("id");
	    int id=Integer.parseInt(a_id);
	    String account= request.getParameter("account");
	    String adminpass= request.getParameter("adminpass");
	    String ty= request.getParameter("type");
	    int type=Integer.parseInt(ty);
	    //ʵ��������
	    Admin admin=new Admin();
	    admin.setA_id(id);
	    admin.setAccount(account);
	    admin.setAdminpass(adminpass);
	    admin.setType(type);
	    //���ú�̨����
	    AdminDAO admindao=new AdminDAOimpl();
	    
	  	Boolean rows=admindao.updateAdmin(admin);
	    if(rows){
	    	//�ɹ�
	    	request.getRequestDispatcher("/success.jsp").forward(request,response);
	    }else{
	    	//ʧ��
	    	request.getRequestDispatcher("/error.jsp").forward(request,response);
	    }
	      
	      
	}
	
}

