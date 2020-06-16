package com.systop.dao;

import java.util.List;

import com.systop.entity.Admin;

public interface AdminDAO {
	public Admin loginAdmin(String account,String adminpass);

	//展示
	public List<Admin> findAdminAll(int pageNow);
	//添加管理员
	public int saveAdmin(Admin admin);
	//修改管理员
	public int updateAdmin(Admin admin);
	//搜索管理员
	public Admin findAdminId(int id);
	//查账号
	public List<Admin> adminFindByAccount(String account);
	//删除管理员
	public int deleteAdminId(int id);

	//获取页数
	public int pages();

	public Admin adminCheck(String account);
}
