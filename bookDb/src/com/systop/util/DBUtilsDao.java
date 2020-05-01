package com.systop.util;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public  class DBUtilsDao {
	/**
	 * 查询所有数据的公用方法，没有参数
	 * @param sql 查询sql语句
	 * @param clazz 返回的类型
	 * @return 集合
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <clazz> List<clazz> findAll(String sql, Class<?> clazz) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//调用方法
		List<clazz> list = (List<clazz>) runner.query(sql, new BeanListHandler(clazz));
		return list;
	}
	
	/**
	 * 根据参数查询数据的公用方法
	 * @param sql sql语句，可以有参数，案例为 xxx where id = ? 
	 * @param clazz 返回类型
	 * @param params 参数集合
	 * @return 集合
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <clazz> List<clazz> findListByParams(String sql, Class<?> clazz, Object ... params) throws SQLException{
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		List<clazz> list = (List<clazz>) runner.query(sql, new BeanListHandler(clazz), params);
		return list;
	} 
	
	/**
	 * 根据参数查询数据的公用方法
	 * @param sql sql语句，可以有参数，案例为 xxx where id = ? 
	 * @param clazz 返回类型
	 * @param params 参数集合
	 * @return 对象
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static <clazz> clazz findObjectByParams(String sql, Class<?> clazz, Object ... params) throws SQLException{
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		clazz c = (clazz) runner.query(sql, new BeanHandler<>(clazz), params);
		return c;
	} 
	
	/**
	 * 增删改方法的调用
	 * @param sql sql语句
	 * @param params 参数列表
	 * @return true成功，false失败
	 * @throws SQLException
	 */
	public static Boolean update(String sql,Object ... params) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		int rows = runner.update(sql, params);
		if(rows > 0) {
			return true;
		}
		return false;
	}
}
