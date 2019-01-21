package com.example.demo.dao.user;

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
	public User selectUserById(int recordId) {
		// TODO Auto-generated method stub
		return null;
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
