package com.systop.servlet.borrow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.BookDao;
import com.systop.dao.UserDao;
import com.systop.dao.impl.BookDaoImpl;
import com.systop.dao.impl.UserDaoImpl;
import com.systop.entity.Book;
import com.systop.entity.User;

/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/borrowCheck")
public class BorrowAddCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BorrowAddCheckServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path=request.getContextPath();
		  //解决中文乱码码问题
	  	request.setCharacterEncoding("UTF-8");
	    //获取页面的值

	    String u= request.getParameter("u_id");
	    int u_id = 0;
	    User user =  new User();
	    user =null;
	    if(u!=null&&!"".equals(u)) {
			u_id = Integer.parseInt(u);	
		
	    //调用后台方法
	    //实例化
	    UserDao typeDao = new UserDaoImpl();
	  		//调后台
	    user = typeDao.findTypeByid(u_id);
	   
	    PrintWriter out = response.getWriter();
		//判断结果
		if (user!= null) {
			//如果有此数据则返回0
			out.write(user.getU_name());
			
		} else {
			//如果无此数据则返回1
			out.write("查无此人");
		}
		out.close();
	    }
	}

}
