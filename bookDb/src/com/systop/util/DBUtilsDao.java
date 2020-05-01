package com.systop.util;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public  class DBUtilsDao {
	/**
	 * ��ѯ�������ݵĹ��÷�����û�в���
	 * @param sql ��ѯsql���
	 * @param clazz ���ص�����
	 * @return ����
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <clazz> List<clazz> findAll(String sql, Class<?> clazz) throws SQLException {
		//����QueryRunner����
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//���÷���
		List<clazz> list = (List<clazz>) runner.query(sql, new BeanListHandler(clazz));
		return list;
	}
	
	/**
	 * ���ݲ�����ѯ���ݵĹ��÷���
	 * @param sql sql��䣬�����в���������Ϊ xxx where id = ? 
	 * @param clazz ��������
	 * @param params ��������
	 * @return ����
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <clazz> List<clazz> findListByParams(String sql, Class<?> clazz, Object ... params) throws SQLException{
		//����QueryRunner����
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		List<clazz> list = (List<clazz>) runner.query(sql, new BeanListHandler(clazz), params);
		return list;
	} 
	
	/**
	 * ���ݲ�����ѯ���ݵĹ��÷���
	 * @param sql sql��䣬�����в���������Ϊ xxx where id = ? 
	 * @param clazz ��������
	 * @param params ��������
	 * @return ����
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static <clazz> clazz findObjectByParams(String sql, Class<?> clazz, Object ... params) throws SQLException{
		//����QueryRunner����
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		clazz c = (clazz) runner.query(sql, new BeanHandler<>(clazz), params);
		return c;
	} 
	
	/**
	 * ��ɾ�ķ����ĵ���
	 * @param sql sql���
	 * @param params �����б�
	 * @return true�ɹ���falseʧ��
	 * @throws SQLException
	 */
	public static Boolean update(String sql,Object ... params) throws SQLException {
		//����QueryRunner����
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		int rows = runner.update(sql, params);
		if(rows > 0) {
			return true;
		}
		return false;
	}
}
