package com.systop.dao.impl;
import java.util.ArrayList;

import java.util.List;
import com.systop.dao.UserDAO;
import com.systop.entity.User;



public class UserDAOimpl extends BaseDAO implements UserDAO {

	//��½��֤����
		public User loginUser(String uName,String uPass){
			
			User user=null;
			/*
			 * //sql���
		String sql = "select * from user where u_name = ? and userpass = ? ";
		try {
			super.getConnection();// ���ø��෽����ȡ���ݿ�����
			pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
			pstm.setString(1, uName);
			pstm.setString(2, uPass);
			//ִ��sql���,�����ؽ����
			rs = pstm.executeQuery();
			//������
			if(rs.next()) {
				user=new User();
				user.setuId(rs.getInt("a_id"))
				user.setAccount(rs.getString("account"));
				user.setAdminpass(rs.getString("adminpass"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("���ݿ����Ӵ���");
		}finally{				
				super.closeAll();					
		}			
			 * 
			 * */
		
		return user;	
		}

		//չʾ����
	

		//���
		@Override
		public int saveUser(User user) {
			int row=0;
			//sql���
			String sql = "insert into user(u_name,u_sex,userpass,u_phone,u_address,u_mail,birthday,type,u_heart,u_status) values(?,?,?,?,?,?,?,?,?,?) ";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				
				pstm.setString(1, user.getuName());
				pstm.setString(2, user.getSex());
				pstm.setString(3, user.getuPass());
				pstm.setString(4, user.getPhone());
				pstm.setString(5, user.getAddress());
				pstm.setString(6, user.getEmail());
				pstm.setString(7, user.getBirthday());
				pstm.setInt(8, 0);
				pstm.setDouble(9, 0);
				pstm.setInt(10, 1);
				
				row = pstm.executeUpdate();// ִ��SQL���,������Ӱ�������
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
			}			
			return row;
		}




		//չʾ
		@Override
		public List<User> findUserAll() {
			List<User> list= new ArrayList<User>();
			//sql���
			String sql = "select * from user";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				//ִ��sql���,�����ؽ����
				rs = pstm.executeQuery();
				//������
				while(rs.next()) {
					User user=new User();
					user.setuId(rs.getInt("u_id"));
					user.setuName(rs.getString("u_name"));
					user.setSex(rs.getString("u_sex"));
					user.setuPass(rs.getString("userpass"));
					user.setPhone(rs.getString("u_phone"));
					user.setAddress(rs.getString("u_address"));
					user.setEmail(rs.getString("u_mail"));
					user.setBirthday(rs.getString("birthday"));
					user.setType(rs.getInt("type"));
					user.setHeart(rs.getDouble("u_heart"));
					user.setStatus(rs.getInt("u_status"));
					
					list.add(user);
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{			
					super.closeAll();					
			}
			return list;	
			
		}

		//�޸��û���Ϣ
		@Override
		public int updateUserXin(User user) {
			int row=0;
			//sql���
			String sql = "update user set u_name = ?,u_sex = ?,userpass = ?,u_phone = ?,u_address = ?,u_mail = ?,birthday = ?,type = ?,u_heart = ?,u_status = ? where u_id = ?";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������		
				pstm.setString(1, user.getuName());
				pstm.setString(2, user.getSex());
				pstm.setString(3, user.getuPass());
				pstm.setString(4, user.getPhone());
				pstm.setString(5, user.getAddress());
				pstm.setString(6, user.getEmail());
				pstm.setString(7, user.getBirthday());
				pstm.setInt(8, user.getType());
				pstm.setDouble(9, user.getHeart());
				pstm.setInt(10, user.getStatus());
				pstm.setInt(11, user.getuId());
				row = pstm.executeUpdate();// ִ��SQL���,������Ӱ�������
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
			}			
			return row;
		}
		
		//�޸��û�״̬
		public int updateUserSt(int id,int st) {
			int row=0;
			//sql���
			String sql = "update user set u_status = ? where u_id = ?";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������		
				pstm.setInt(1, st);
				pstm.setInt(2, id);
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
		public User findUserId(int id) {
			User user=null;
			//sql���
			String sql = "select * from user where u_id = ?";
			try {
				super.getConnection();// ���ø��෽����ȡ���ݿ�����
				pstm = con.prepareStatement(sql);// ����Ԥ�����SQL������
				pstm.setInt(1, id);
				//ִ��sql���,�����ؽ����
				rs = pstm.executeQuery();
				//������
				if(rs.next()) {
					user=new User();
					user.setuId(rs.getInt("u_id"));
					user.setuName(rs.getString("u_name"));
					user.setSex(rs.getString("u_sex"));
					user.setuPass(rs.getString("userpass"));
					user.setPhone(rs.getString("u_phone"));
					user.setAddress(rs.getString("u_address"));
					user.setEmail(rs.getString("u_mail"));
					user.setBirthday(rs.getString("birthday"));
					user.setType(rs.getInt("type"));
					user.setHeart(rs.getDouble("u_heart"));
					user.setStatus(rs.getInt("u_status"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.print("���ݿ����Ӵ���");
			}finally{				
					super.closeAll();					
			}			
			return user;	
		}

		//ɾ��
		@Override
		public int deleteUserId(int id) {
			int row=0;
			//sql���
			String sql = "delete from user where u_id = ? ";
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
	


}