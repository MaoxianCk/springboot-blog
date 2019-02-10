package com.example.demo.dao;

import java.sql.*;

/**
 * 数据库连接通用类 Dao层基类 包含数据库jdbc连接关闭操作
 * 
 * @author:Maoxian
 * @creat:2019-01-21 17:49
 */
public class BaseDao {
	// 数据库连接参数
	private static String url = "jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Shanghai";// 时区设置
	private static String user = "root";
	private static String password = "123456";

	/*
	 * //JDBC不再需要显式加载驱动; 
	 * private static String driver = "com.mysql.cj.jdbc.Driver";
	 * static { try { Class.forName(driver); } catch (ClassNotFoundException e) {
	 * e.printStackTrace(); } }
	 */

	// 建立数据库连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	// 断开数据库连接
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
	}

}
