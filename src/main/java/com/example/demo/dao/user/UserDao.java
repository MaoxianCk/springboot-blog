package com.example.demo.dao.user;

import java.util.List;

import com.example.demo.entity.User;


public interface UserDao {
	public boolean insertUser(User recordUser);
	
	public boolean deleteUserById(int recordId);
	
	public User selectUserById(int recordId) throws Exception;
	public User selectUserByAccount(String recordAccount);
	public List<User> selectUserByName(String recordName);	
	public List<User> selectUserByGroup(int recordGroup);
	
	public boolean updateUser(User recordUser);
}
