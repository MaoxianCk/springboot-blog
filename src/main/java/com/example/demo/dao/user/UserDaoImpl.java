package com.example.demo.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.example.demo.dao.BaseDao;
import com.example.demo.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int insertUser(User recordUser) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into user_account(account,password,name,role) values(?,?,?,?)";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recordUser.getAccount());
			stmt.setString(2, recordUser.getPassword());
			stmt.setString(3, recordUser.getName());
			stmt.setInt(4, recordUser.getRole());
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 插入用户错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public int deleteUserById(int recordId) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from user_account where id = ?";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recordId);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 删除用户错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public User selectUserById(int recordId) throws Exception {
		//System.out.println("---------- 查询 id : "+recordId+" 用户 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from user_account where id = " + recordId;
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		User user = null;
		//int i=0;
		while (rs.next()) {
			user = new User(rs.getInt("id"), rs.getString("account"), rs.getString("password"), rs.getString("name"),
					rs.getInt("role"),rs.getTimestamp("last_login_time"));
		//	i++;
		}
		
		//System.out.println("---------- 查询到 "+ i +" 条用户 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return user;
	}

	@Override
	public User selectUserByAccount(String recordAccount) throws Exception {
		//System.out.println("---------- 查询 account : "+recordAccount+" 用户 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from user_account where account = '" + recordAccount+"'";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		User user = null;
		//int i=0;
		while (rs.next()) {
			user = new User(rs.getInt("id"), rs.getString("account"), rs.getString("password"), rs.getString("name"),
					rs.getInt("role"),rs.getTimestamp("last_login_time"));
		//	i++;
			break;
		}
		
		//System.out.println("---------- 查询到 "+ i +" 条用户 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return user;
	}

	@Override
	public List<User> selectUserByName(String recordName) throws Exception {
		//System.out.println("---------- 查询 name : "+recordName+" 用户 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from user_account where name = " + recordName;
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<User> list=new ArrayList<User>();
		while (rs.next()) {
			User user = new User(rs.getInt("id"), rs.getString("account"), rs.getString("password"), rs.getString("name"),
					rs.getInt("role"),rs.getTimestamp("last_login_time"));
			list.add(user);
		}
		//System.out.println("---------- 查询到 "+ list.size() +" 条用户 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<User> selectUserByRole(int recordRole) throws Exception {
		//System.out.println("---------- 查询 role : "+recordRole+" 用户 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from user_account where role = " + recordRole;
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<User> list=new ArrayList<User>();
		while (rs.next()) {
			User user = new User(rs.getInt("id"), rs.getString("account"), rs.getString("password"), rs.getString("name"),
					rs.getInt("role"),rs.getTimestamp("last_login_time"));
			list.add(user);
		}
		//System.out.println("---------- 查询到 "+ list.size() +" 条用户 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}

	@Override
	public List<User> selectUserAll() throws Exception {
		//System.out.println("---------- 查询所有用户 ----------");
		Connection conn = BaseDao.getConnection();
		String sql = "select * from user_account where role = 2 OR role = 3 order by last_login_time Desc";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<User> list=new ArrayList<User>();
		while (rs.next()) {
			User user = new User(rs.getInt("id"), rs.getString("account"), rs.getString("password"), rs.getString("name"),
					rs.getInt("role"),rs.getTimestamp("last_login_time"));
			list.add(user);
		}
		//System.out.println("---------- 查询到 "+ list.size() +" 条用户 ---------");

		BaseDao.closeAll(conn, stmt, rs);
		return list;
	}
	

	@Override
	public int updateUser(User recordUser) throws Exception {
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update user_account set password = ?, name = ?, role = ? where id = ?";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recordUser.getPassword());
			stmt.setString(2, recordUser.getName());
			stmt.setInt(3, recordUser.getRole());
			stmt.setInt(4, recordUser.getId());
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 修改用户错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}

	@Override
	public int updateUserLoginTime(int id) throws Exception{
		Connection conn = BaseDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update user_account set last_login_time = ? where id = ?";
		int i = -1;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			stmt.setInt(2, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------- 修改用户错误 ----------");
		}

		BaseDao.closeAll(conn, stmt, null);
		return i;
	}
}
