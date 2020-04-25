package com.systop.dao;

import java.util.List;
import com.systop.entity.User;

public interface UserDAO {
	public User loginUser(String uid,String uPass);

	//展示
	public List<User> findUserAll();
	//添加用户
	public int saveUser(User user);
	//修改用户信息
	public int updateUserXin(User user);
	//修改用户状态
	public int updateUserSt(int id,int st);
	//搜索用户
	public User findUserId(int id);
	//删除用户
	public int deleteUserId(int id);


}
