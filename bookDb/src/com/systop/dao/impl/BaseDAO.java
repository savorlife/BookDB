package com.systop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	//连接数据库参数
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bookdb";
	private static final String UNAME = "root";
	private static final String UPWD = "root";

	//数据库对象
	protected Connection con;// 数据库连接对象
	protected PreparedStatement pstm;// 预编译的SQL语句对象
	protected Statement stmt;// SQL语句对象
	protected ResultSet rs;// 结果集对象

	/**
	 * 获取数据库连接方法
	 * @throws Exception
	 */
	protected void getConnection() throws Exception {
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL, UNAME, UPWD);
	}

	/**
	 * 释放数据库资源
	 */
	protected void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			if (con != null && con.isClosed() == false) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行SQL语句,可以执行增、删、改的操作，不能执行查询
	 * @param sql    预编译的sql语句
	 * @param param  sql语句参数数组
	 * @return rows  返回受影响的行数
	 */
	protected int executeSQL(String sql, String[] param) throws Exception {
		int rows = 0; // 受影响的行数

		try {
			this.getConnection();
			if (param != null && param.length > 0) {
				pstm = con.prepareStatement(sql);
				// 循环，将SQL语句参数数组中的值依次赋给预执行语句
				for (int i = 0; i < param.length; i++) {
					// 注意，setXXX()方法的索引值从1开始，所以有i+1
					pstm.setString(i + 1, param[i]);
				}
				rows = pstm.executeUpdate();
			} else {
				// 创建Statement对象，执行更新sql语句，返回受影响的行数
				stmt = con.createStatement();
				rows = stmt.executeUpdate(sql);
			}
		} finally {
			this.closeAll();// 释放资源
		}
		System.out.println("调用通用的增、删、改方法成功！");
		return rows;// 返回受影响的行数
	}
}
