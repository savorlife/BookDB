package com.systop.servlet;

import com.systop.entity.Admin;
import com.systop.dao.AdminDAO;
import com.systop.dao.impl.AdminDAOimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * 
 * 
 */
@WebServlet("/adminDelete")
public class AdminDeleteServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1689534048808360168L;

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
	    String id= request.getParameter("id");
		int aid=Integer.parseInt(id);
	    //���ú�̨����
	    AdminDAO admindao=new AdminDAOimpl();
	    Boolean rows= admindao.deleteAdminId(aid);
	    if(rows){
	    	//�ɹ�
	 //   	request.getRequestDispatcher("/adminList").forward(request,response);
	    	response.sendRedirect(path+"/adminList");
	    }else{
	    	//ʧ��
	    	request.getRequestDispatcher("/error.jsp").forward(request,response);
	    	
	    }
	   	
	}
	
	
}
