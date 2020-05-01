package com.systop.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//定义数据源属性
	private static DataSource ds;

	static {
		//获取C3P0连接池对象
		ds = new ComboPooledDataSource();
	}
	//提供公共方法返回数据源
	public static DataSource getDataSource() {
		return ds;
	}
}