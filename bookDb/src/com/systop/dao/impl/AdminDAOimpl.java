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
	
		//ÿҳ��ʾ��
		int pageSize=10;
	
	
		//��½��֤����
		public Admin loginAdmin(String adminName,String adminPwd){
		Admin admin=null;
		//sql���
		String sql = "select * from admin where account = ? and adminpass = ? ";

		try {
			 admin = DBUtilsDao.findObjectByParams(sql, Admin.class, adminName,adminPwd);
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
				
		return admin;	
		}

		//չʾ
		public List<Admin> findAdminAll(int pageNow){
			
			int pages=this.pages();
			if(pageNow>0||pageNow<pages) {
				pageNow=(pageNow-1)*pageSize;
			}else {
				pageNow=1;
			}
			
			List<Admin> list= new ArrayList<Admin>();
			//sql���
			String sql = "select * from admin order by admin.type desc limit ?,?";
			
			try {
				list=DBUtilsDao.findListByParams(sql, Admin.class, pageNow,pageSize);
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			} 
			
			return list;	
			
		}

		//���
		@Override
		public int saveAdmin(Admin admin) {
		
			//sql���
			String sql = "insert into admin(account,adminpass,type) values (?,?,?)";
			
			int row = 0;
			try {
				row = DBUtilsDao.update(sql, admin.getAccount(), admin.getAdminpass(),admin.getType());
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
				
			return row;
		}

		//����
		@Override
		public int updateAdmin(Admin admin) {
		
			String sql = "update admin set account = ?,adminpass = ?,type = ? where a_id = ?";
			
			int row = 0;
			try {
				row = DBUtilsDao.update(sql, admin.getAccount(), admin.getAdminpass(),admin.getType(),admin.getA_id());
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
					
			return row;
		}

		//����
		@Override
		public Admin findAdminId(int id) {
			Admin admin=null;
			//sql���
			String sql = "select * from admin where a_id = ?";
			
			try {
				admin=DBUtilsDao.findObjectByParams(sql, Admin.class, id);
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			
			return admin;	
		}
		
		
		
		public Admin adminCheck(String account) {
			Admin admin=null;
			//sql���
			String sql = "select * from admin where account = ?";
			try {
				admin=DBUtilsDao.findObjectByParams(sql, Admin.class, account);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
					
			return admin;	
		}

		//ɾ��
		@Override
		public int deleteAdminId(int id) {

			String sql = "delete from admin where a_id = ? ";
			
			int row = 0;
			try {
				row = DBUtilsDao.update(sql,id);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
						
			return row;
		}
		//��ȡ������
		@Override
		public int pages() {
			String url="jdbc:mysql://localhost:3306/bookdb";//�������ݿ�ĵ�ַ
			String user="root";//�������ݿ��ǵ��û���
			String password="root";//�������ݿ��ǵ�����
			
		//sql���
			int counts=0;
			String sql = "select count(*) from admin";
			try {
				//1.���ز�ע������(����������ȥ��.class���޶�����
				Class.forName("com.mysql.jdbc.Driver");
				//2.�������ӣ��ţ�
				Connection con=DriverManager.getConnection(url, user, password);
				//3.����һ��PreparedStatement���󣨳�����Ԥ����
				PreparedStatement pstmt=con.prepareStatement(sql);
		
				//ִ��sql���,�����ؽ����
				ResultSet rs = pstmt.executeQuery();
				//������
				if(rs.next()) {
					counts = rs.getInt(1);
				}
				//�ر���Դ
				rs.close();
				pstmt.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}	
			int pages=counts/pageSize;
			if(counts%pageSize!=0) {
				pages=pages+1;
				
			} 
			return pages;	
		}
	


}