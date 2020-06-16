package com.systop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.systop.dao.TypeDao;
import com.systop.entity.Type;
import com.systop.util.DBUtilsDao;

public class TypeDaoImpl implements TypeDao{


	
	@Override
	public List<Type> findTypeAll(String typeName) {
		List<Type> list = null;
		String sql = "select * from type where 1 = 1";
		if(typeName!=null&&!"".equals(typeName)) {
			sql+=" and typeName like '%"+typeName;
			sql+="%'";
		}
		try {
			list = DBUtilsDao.findAll(sql, Type.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Type findTypeByid(int typeID) {
		Type type = null;
		String sql = "select * from type where typeID = ?";
		//调用后台方法
		try {
			type = DBUtilsDao.findObjectByParams(sql, Type.class,typeID);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public int addType(Type type) {
		int i = 0;
		String sql = "insert into type (typeName) values (?)";
		//调用后台方法
		try {
			i = DBUtilsDao.update(sql,type.getTypeName());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateType(Type type) {
		int i = 0;
		String sql = "update type set typeName = ? where typeID = ?";
		//调用后台方法
		try {
			i = DBUtilsDao.update(sql,type.getTypeName(),type.getTypeID());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deletType(int typeID) {
		int i = 0;
		String sql = "delete from type where typeID = ?";
		//调用后台方法
		try {
			i = DBUtilsDao.update(sql, typeID);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}

}
