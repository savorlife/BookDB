package com.systop.dao.impl;
import java.util.ArrayList;
import com.systop.entity.Admin;

import java.util.List;
import com.systop.dao.AdminDAO;



public class AdminDAOimpl extends BaseDAO implements AdminDAO {
	
		//ÿҳ��ʾ��
		int pageSize=10;
	
	
		//��½��֤����
		public Admin loginAdmin(String adminName,String adminPwd){
		Admin admin=null;
		//sql���
		String sql = "select * from admin where account = ? and adminpass = ? ";
		try {
			super.getConnection();// ���ø��෽����ȡ���ݿ�����
			pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
			pstm.setString(1, adminName);
			pstm.setString(2, adminPwd);
			//ִ��sql���,�����ؽ����
			rs = pstm.executeQuery();
			//������
			if(rs.next()) {
				admin=new Admin();
				admin.setA_id(rs.getInt("a_id"));
				admin.setAccount(rs.getString("account"));
				admin.setAdminpass(rs.getString("adminpass"));
				admin.setType(rs.getInt("type"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("���ݿ����Ӵ���");
		}finally{				
				super.closeAll();					
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
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				pstm.setInt(1, pageNow);
				pstm.setInt(2, pageSize);
				//ִ��sql���,�����ؽ����
				rs = pstm.executeQuery();
				//������
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
				System.out.print("���ݿ����Ӵ���");
			}finally{			
					super.closeAll();					
			}
			return list;	
			
		}

		//���
		@Override
		public int saveAdmin(Admin admin) {
			int row=0;
			//sql���
			String sql = "insert into admin(account,adminpass,type) values (?,?,?)";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				pstm.setString(1, admin.getAccount());
				pstm.setString(2, admin.getAdminpass());
				pstm.setInt(3, admin.getType());
				row = pstm.executeUpdate();// ִ��SQL���,������Ӱ�������
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
			}			
			return row;
		}

		//����
		@Override
		public int updateAdmin(Admin admin) {
			int row=0;
			//sql���
			String sql = "update admin set account = ?,adminpass = ?,type = ? where a_id = ?";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������		
				pstm.setString(1, admin.getAccount());
				pstm.setString(2, admin.getAdminpass());
				pstm.setInt(3, admin.getType());
				pstm.setInt(4, admin.getA_id());
				row = pstm.executeUpdate();// ִ��SQL���,������Ӱ�������
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
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
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				pstm.setInt(1, id);
				//ִ��sql���,�����ؽ����
				rs = pstm.executeQuery();
				//������
				if(rs.next()) {
					admin=new Admin();
					admin.setA_id(rs.getInt("a_id"));
					admin.setAccount(rs.getString("account"));
					admin.setAdminpass(rs.getString("adminpass"));
					admin.setType(rs.getInt("type"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
			}			
			return admin;	
		}
		
		
		
		public Admin adminCheck(String account) {
			Admin admin=null;
			//sql���
			String sql = "select * from admin where account = ?";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				pstm.setString(1, account);
				//ִ��sql���,�����ؽ����
				rs = pstm.executeQuery();
				//������
				if(rs.next()) {
					admin=new Admin();
					admin.setA_id(rs.getInt("a_id"));
					admin.setAccount(rs.getString("account"));
					admin.setAdminpass(rs.getString("adminpass"));
					admin.setType(rs.getInt("type"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
			}			
			return admin;	
		}

		//ɾ��
		@Override
		public int deleteAdminId(int id) {
			int row=0;
			//sql���
			String sql = "delete from admin where a_id = ? ";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				pstm.setInt(1, id);
				row = pstm.executeUpdate();// ִ��SQL���,������Ӱ�������
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
			}			
			return row;
		}
		//��ȡ������
		@Override
		public int pages() {
			//sql���
			int counts=0;
			String sql = "select count(*) from admin";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				//ִ��sql���,�����ؽ����
				rs = pstm.executeQuery();
				//������
				if(rs.next()) {
					counts = rs.getInt(1);
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
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