package com.systop.dao;

import java.util.List;

import com.systop.entity.Admin;

public interface AdminDAO {
	public Admin loginAdmin(String account,String adminpass);

	//չʾ
	public List<Admin> findAdminAll(int pageNow);
	//��ӹ���Ա
	public Boolean saveAdmin(Admin admin);
	//�޸Ĺ���Ա
	public Boolean updateAdmin(Admin admin);
	//��������Ա
	public Admin findAdminId(int id);
	//����
	public Admin adminCheck(String account);
	//ɾ������Ա
	public Boolean deleteAdminId(int id);

	//��ȡҳ��
	public int pages();
}
