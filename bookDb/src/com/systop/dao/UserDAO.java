package com.systop.dao;

import java.util.List;

import com.systop.entity.User;

public interface UserDao {

	public User loginUser(String u_id,String u_pass);
	//查询列表所有信息
	public List<User> findTypeAll();
	
	//根据名称查1
	public List<User> findTypeListByName(String u_name);
	
	//根据id查1
	public User findTypeByid(int u_id);
	//根据手机号查
	public User findTypeByPhone(String phone);
	//添加
	public int addType(User user);
		
	//修改
	public int updateType(User user);
	
	//删除
	public int deletType(int u_id);
}
