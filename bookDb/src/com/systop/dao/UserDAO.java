package com.systop.dao;

import java.util.List;
import com.systop.entity.User;

public interface UserDAO {
	public User loginUser(String uid,String uPass);

	//չʾ
	public List<User> findUserAll();
	//����û�
	public int saveUser(User user);
	//�޸��û���Ϣ
	public int updateUserXin(User user);
	//�޸��û�״̬
	public int updateUserSt(int id,int st);
	//�����û�
	public User findUserId(int id);
	//ɾ���û�
	public int deleteUserId(int id);


}
