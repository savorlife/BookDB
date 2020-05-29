package com.systop.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.systop.entity.Admin;
import com.systop.util.DBUtilsDao;

import java.util.List;


import com.systop.dao.AdminDAO;



public class AdminDAOimpl  implements AdminDAO {
	
		//每页显示数
		int pageSize=10;
	
	
		//登陆验证方法
		public Admin loginAdmin(String adminName,String adminPwd){
		Admin admin=null;
		//sql语句
		String sql = "select * from admin where account = ? and adminpass = ? ";

		try {
			 admin = DBUtilsDao.findObjectByParams(sql, Admin.class, adminName,adminPwd);
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
				
		return admin;	
		}

		//展示
		public List<Admin> findAdminAll(int pageNow){
			
			int pages=this.pages();
			if(pageNow>0||pageNow<pages) {
				pageNow=(pageNow-1)*pageSize;
			}else {
				pageNow=1;
			}
			
			List<Admin> list= new ArrayList<Admin>();
			//sql语句
			String sql = "select * from admin order by admin.type desc limit ?,?";
			
			try {
				list=DBUtilsDao.findListByParams(sql, Admin.class, pageNow,pageSize);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} 
			
			return list;	
			
		}

		//添加
		@Override
		public int saveAdmin(Admin admin) {
		
			//sql语句
			String sql = "insert into admin(account,adminpass,type) values (?,?,?)";
			
			int row = 0;
			try {
				row = DBUtilsDao.update(sql, admin.getAccount(), admin.getAdminpass(),admin.getType());
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
				
			return row;
		}

		//更新
		@Override
		public int updateAdmin(Admin admin) {
		
			String sql = "update admin set account = ?,adminpass = ?,type = ? where a_id = ?";
			
			int row = 0;
			try {
				row = DBUtilsDao.update(sql, admin.getAccount(), admin.getAdminpass(),admin.getType(),admin.getA_id());
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
					
			return row;
		}

		//查找
		@Override
		public Admin findAdminId(int id) {
			Admin admin=null;
			//sql语句
			String sql = "select * from admin where a_id = ?";
			
			try {
				admin=DBUtilsDao.findObjectByParams(sql, Admin.class, id);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
			return admin;	
		}
		
		
		
		public Admin adminCheck(String account) {
			Admin admin=null;
			//sql语句
			String sql = "select * from admin where account = ?";
			try {
				admin=DBUtilsDao.findObjectByParams(sql, Admin.class, account);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
					
			return admin;	
		}

		//删除
		@Override
		public int deleteAdminId(int id) {

			String sql = "delete from admin where a_id = ? ";
			
			int row = 0;
			try {
				row = DBUtilsDao.update(sql,id);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
						
			return row;
		}
		//获取数据量
		@Override
		public int pages() {
			String url="jdbc:mysql://localhost:3306/bookdb";//连接数据库的地址
			String user="root";//连接数据库是的用户名
			String password="root";//连接数据库是的密码
			
		//sql语句
			int counts=0;
			String sql = "select count(*) from admin";
			try {
				//1.加载并注册驱动(用引号括起去掉.class的限定名）
				Class.forName("com.mysql.jdbc.Driver");
				//2.创建链接（桥）
				Connection con=DriverManager.getConnection(url, user, password);
				//3.创建一个PreparedStatement对象（车），预处理
				PreparedStatement pstmt=con.prepareStatement(sql);
		
				//执行sql语句,并返回结果集
				ResultSet rs = pstmt.executeQuery();
				//处理结果
				if(rs.next()) {
					counts = rs.getInt(1);
				}
				//关闭资源
				rs.close();
				pstmt.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}	
			int pages=counts/pageSize;
			if(counts%pageSize!=0) {
				pages=pages+1;
				
			} 
			return pages;	
		}
	


}