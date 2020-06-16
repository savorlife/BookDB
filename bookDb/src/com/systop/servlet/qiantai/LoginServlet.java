package com.systop.servlet.qiantai;

import com.systop.entity.User;
import com.systop.dao.UserDao;
import com.systop.dao.impl.UserDaoImpl;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 
 */
@WebServlet("/loginIndex")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7497140150886180490L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		String path=request.getContextPath();
		session.setAttribute("path", path);
		
			
			//�����������������
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("login/html;charset=UTF-8");
			//��ȡ������
			String u_id=request.getParameter("u_id");
			String u_pass=request.getParameter("u_pass");
			//���ú�̨������½
			UserDao userdao=new UserDaoImpl();
			User user=userdao.loginUser(u_id, u_pass);
			if(user!=null){
				//�ɹ�
				session.setAttribute("user",user);
				request.getRequestDispatcher("/index").forward(request, response); 
			}else{
				//ʧ��
				request.setAttribute("show", "show");
				request.setAttribute("cuo", "�û���������������������룡");
				request.getRequestDispatcher("/index").forward(request, response);
				//response.sendRedirect("/hagen_dazs/login.jsp"); // �ض���:��תҳ��
			}
	}
	
	
}
