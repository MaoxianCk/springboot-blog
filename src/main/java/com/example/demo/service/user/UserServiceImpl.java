package com.example.demo.service.user;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.service.BaseService;

public class UserServiceImpl extends BaseService implements UserService {

	@Override
	public void addUser(User user) {
		try {

			userDaoImpl.insertUser(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		try {

			userDaoImpl.deleteUserById(userId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		try {

			userDaoImpl.updateUser(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setLoginTime(int id) {
		try {
			
			userDaoImpl.updateUserLoginTime(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findUser(String account) {
		User user = null;
		try {
			user = userDaoImpl.selectUserByAccount(account);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return user;
	}
	@Override
	public User findUser(int id) {
		User user = null;
		try {

			user = userDaoImpl.selectUserById(id);

		} catch (Exception e) {
			e.getStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findUsers(String name) {
		List<User> list = new ArrayList<User>();
		try {
			
			list = userDaoImpl.selectUserByName(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> findUsers(int role) {
		List<User> list = new ArrayList<User>();
		try {
			
			list = userDaoImpl.selectUserByRole(role);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
