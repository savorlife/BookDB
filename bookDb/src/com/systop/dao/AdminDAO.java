package com.systop.dao;

import java.util.List;

import com.systop.entity.Admin;

public interface AdminDAO {
	public Admin loginAdmin(String account,String adminpass);

	//չʾ
	public List<Admin> findAdminAll(int pageNow);
	//��ӹ���Ա
	public int saveAdmin(Admin admin);
	//�޸Ĺ���Ա
	public int updateAdmin(Admin admin);
	//��������Ա
	public Admin findAdminId(int id);
	//���˺�
	public List<Admin> adminFindByAccount(String account);
	//ɾ������Ա
	public int deleteAdminId(int id);

	//��ȡҳ��
	public int pages();

	public Admin adminCheck(String account);
}
