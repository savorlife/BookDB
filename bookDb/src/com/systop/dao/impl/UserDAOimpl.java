package com.systop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.systop.dao.UserDao;
import com.systop.entity.User;
import com.systop.util.DBUtilsDao;

public class UserDaoImpl implements UserDao{
	
	//��½��֤����
			public User loginUser(String u_id,String u_pass){
				User user=null;
			//sql���
			String sql = "select * from user where u_id = ? and userpass = ? ";

			try {
				user = DBUtilsDao.findObjectByParams(sql, User.class, u_id,u_pass);
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
					
			return user;	
			}

	@Override
	public List<User> findTypeAll() {
		List<User> list = null;
		String sql = "select * from user";
		//���ú�̨����
		try {
			list = DBUtilsDao.findAll(sql ,User.class);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> findTypeListByName(String u_name) {
		List<User> list = null;
		String sql = "select * from user where u_name like ?";
		//���ú�̨����
		try {
			list = DBUtilsDao.findListByParams(sql, User.class, "%"+u_name+"%");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User findTypeByid(int u_id) {
		User user = null;
		String sql = "select * from user where u_id = ?";
		//���ú�̨����
		try {
			user = DBUtilsDao.findObjectByParams(sql, User.class, u_id);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return user;
	}
	public User findTypeByPhone(String phone) {
		User user = null;
		String sql = "select * from user where u_phone = ?";
		//���ú�̨����
		try {
			user = DBUtilsDao.findObjectByParams(sql, User.class, phone);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int addType(User user) {
		int i = 0;
		String sql = "insert into user (u_name,u_phone,userpass,max";
		if(user.getU_id() != 0) {
			sql+=",u_id) values (?,?,?,?,"+user.getU_id();
			sql+=")";
		}else {
			sql+=") values (?,?,?,?)";
		}
		
		//���ú�̨����
		try {
			i = DBUtilsDao.update(sql, user.getU_name(), user.getU_phone(),user.getUserpass(),user.getMax());
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateType(User user) {
		int i = 0;
		String sql = "update user set u_name = ?,u_phone = ?,userpass = ?,max = ? where u_id = ?";
		//���ú�̨����
		try {
			i = DBUtilsDao.update(sql, user.getU_name(),user.getU_phone(),user.getUserpass(),user.getMax(),user.getU_id());
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deletType(int u_id) {
		int i = 0;
		String sql = "delete from user where u_id = ?";
		//���ú�̨����
		try {
			i = DBUtilsDao.update(sql, u_id);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return i;
	}

}
