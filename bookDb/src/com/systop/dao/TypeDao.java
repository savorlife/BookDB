package com.systop.dao;

import java.util.List;

import com.systop.entity.Type;

public interface TypeDao {

	//查询列表所有信息
	public List<Type> findTypeAll(String typeName);
	
	//根据id查
	public Type findTypeByid(int id);
	
	//添加
	public int addType(Type type);
		
	//修改
	public int updateType(Type type);
	
	//删除
	public int deletType(int id);
}
