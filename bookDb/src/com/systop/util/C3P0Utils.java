package com.systop.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//��������Դ����
	private static DataSource ds;

	static {
		//��ȡC3P0���ӳض���
		ds = new ComboPooledDataSource();
	}
	//�ṩ����������������Դ
	public static DataSource getDataSource() {
		return ds;
	}
}