package com.systop.dao;

import java.util.List;

import com.systop.entity.Type;

public interface TypeDao {

	//��ѯ�б�������Ϣ
	public List<Type> findTypeAll(String typeName);
	
	//����id��
	public Type findTypeByid(int id);
	
	//���
	public int addType(Type type);
		
	//�޸�
	public int updateType(Type type);
	
	//ɾ��
	public int deletType(int id);
}
