package com.example.demo.dao;

import java.sql.*;

/**
 * 数据库连接通用类
 * 
 * @author:Maoxian
 * @creat:2019-01-21 17:49
 */
public class BaseDao {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Shanghai";
	private static String user = "root";
	private static String password = "123456";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

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
