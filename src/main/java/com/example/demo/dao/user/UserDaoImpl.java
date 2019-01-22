package com.example.demo.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.example.demo.dao.BaseDao;
import com.example.demo.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean insertUser(User recordUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserById(int recordId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User selectUserById(int recordId) throws Exception {
		Connection conn = BaseDao.getConnection();
		String sql = "select * from user_account where id = " + recordId;
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();

		User user = new User(rs.getInt("id"), rs.getString("account"), rs.getString("password"), rs.getString("name"),
				rs.getInt("group"));

		BaseDao.closeAll(conn, stmt, rs);
		return user;
	}

	@Override
	public User selectUserByAccount(String recordAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectUserByName(String recordName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectUserByGroup(int recordGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User recordUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
