package com.systop.dao.impl;
import java.util.ArrayList;
import com.systop.entity.Admin;

import java.util.List;
import com.systop.dao.AdminDAO;



public class AdminDAOimpl extends BaseDAO implements AdminDAO {
	
		//每页显示数
		int pageSize=10;
	
	
		//登陆验证方法
		public Admin loginAdmin(String adminName,String adminPwd){
		Admin admin=null;
		//sql语句
		String sql = "select * from admin where account = ? and adminpass = ? ";
		try {
			super.getConnection();// 调用父类方法获取数据库连接
			pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象
			pstm.setString(1, adminName);
			pstm.setString(2, adminPwd);
			//执行sql语句,并返回结果集
			rs = pstm.executeQuery();
			//处理结果
			if(rs.next()) {
				admin=new Admin();
				admin.setA_id(rs.getInt("a_id"));
				admin.setAccount(rs.getString("account"));
				admin.setAdminpass(rs.getString("adminpass"));
				admin.setType(rs.getInt("type"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("数据库连接错误");
		}finally{				
				super.closeAll();					
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
				super.getConnection();// 调用父类方法获取数据库连接
				pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象
				pstm.setInt(1, pageNow);
				pstm.setInt(2, pageSize);
				//执行sql语句,并返回结果集
				rs = pstm.executeQuery();
				//处理结果
				while(rs.next()) {
					Admin admin=new Admin();
					admin.setA_id(rs.getInt("a_id"));
					admin.setAccount(rs.getString("account"));
					admin.setAdminpass(rs.getString("adminpass"));
					admin.setType(rs.getInt("type"));
					list.add(admin);
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}finally{			
					super.closeAll();					
			}
			return list;	
			
		}

		//添加
		@Override
		public int saveAdmin(Admin admin) {
			int row=0;
			//sql语句
			String sql = "insert into admin(account,adminpass,type) values (?,?,?)";
			try {
				super.getConnection();// 调用父类方法获取数据库连接
				pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象
				pstm.setString(1, admin.getAccount());
				pstm.setString(2, admin.getAdminpass());
				pstm.setInt(3, admin.getType());
				row = pstm.executeUpdate();// 执行SQL语句,返回受影响的行数
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}finally{				
					super.closeAll();					
			}			
			return row;
		}

		//更新
		@Override
		public int updateAdmin(Admin admin) {
			int row=0;
			//sql语句
			String sql = "update admin set account = ?,adminpass = ?,type = ? where a_id = ?";
			try {
				super.getConnection();// 调用父类方法获取数据库连接
				pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象		
				pstm.setString(1, admin.getAccount());
				pstm.setString(2, admin.getAdminpass());
				pstm.setInt(3, admin.getType());
				pstm.setInt(4, admin.getA_id());
				row = pstm.executeUpdate();// 执行SQL语句,返回受影响的行数
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}finally{				
					super.closeAll();					
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
				super.getConnection();// 调用父类方法获取数据库连接
				pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象
				pstm.setInt(1, id);
				//执行sql语句,并返回结果集
				rs = pstm.executeQuery();
				//处理结果
				if(rs.next()) {
					admin=new Admin();
					admin.setA_id(rs.getInt("a_id"));
					admin.setAccount(rs.getString("account"));
					admin.setAdminpass(rs.getString("adminpass"));
					admin.setType(rs.getInt("type"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}finally{				
					super.closeAll();					
			}			
			return admin;	
		}
		
		
		
		public Admin adminCheck(String account) {
			Admin admin=null;
			//sql语句
			String sql = "select * from admin where account = ?";
			try {
				super.getConnection();// 调用父类方法获取数据库连接
				pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象
				pstm.setString(1, account);
				//执行sql语句,并返回结果集
				rs = pstm.executeQuery();
				//处理结果
				if(rs.next()) {
					admin=new Admin();
					admin.setA_id(rs.getInt("a_id"));
					admin.setAccount(rs.getString("account"));
					admin.setAdminpass(rs.getString("adminpass"));
					admin.setType(rs.getInt("type"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}finally{				
					super.closeAll();					
			}			
			return admin;	
		}

		//删除
		@Override
		public int deleteAdminId(int id) {
			int row=0;
			//sql语句
			String sql = "delete from admin where a_id = ? ";
			try {
				super.getConnection();// 调用父类方法获取数据库连接
				pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象
				pstm.setInt(1, id);
				row = pstm.executeUpdate();// 执行SQL语句,返回受影响的行数
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}finally{				
					super.closeAll();					
			}			
			return row;
		}
		//获取数据量
		@Override
		public int pages() {
			//sql语句
			int counts=0;
			String sql = "select count(*) from admin";
			try {
				super.getConnection();// 调用父类方法获取数据库连接
				pstm = con.prepareStatement(sql);// 创建预编译的SQL语句对象
				//执行sql语句,并返回结果集
				rs = pstm.executeQuery();
				//处理结果
				if(rs.next()) {
					counts = rs.getInt(1);
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("数据库连接错误");
			}finally{				
					super.closeAll();					
			}	
			int pages=counts/pageSize;
			if(counts%pageSize!=0) {
				pages=pages+1;
				
			} 
			return pages;	
		}
	


}