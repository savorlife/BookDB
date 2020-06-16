package com.systop.dao;

import java.util.List;

import com.systop.entity.User;

public interface UserDao {

	public User loginUser(String u_id,String u_pass);
	//��ѯ�б�������Ϣ
	public List<User> findTypeAll();
	
	//�������Ʋ�1
	public List<User> findTypeListByName(String u_name);
	
	//����id��1
	public User findTypeByid(int u_id);
	//�����ֻ��Ų�
	public User findTypeByPhone(String phone);
	//���
	public int addType(User user);
		
	//�޸�
	public int updateType(User user);
	
	//ɾ��
	public int deletType(int u_id);
}
