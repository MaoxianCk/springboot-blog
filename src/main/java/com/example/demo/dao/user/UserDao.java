package com.example.demo.dao.user;

import java.util.List;

import com.example.demo.entity.User;


public interface UserDao {
	public int insertUser(User recordUser) throws Exception;
	
	public int deleteUserById(int recordId) throws Exception;
	
	public User selectUserById(int recordId) throws Exception;
	public User selectUserByAccount(String recordAccount) throws Exception;
	public List<User> selectUserByName(String recordName) throws Exception;	
	public List<User> selectUserByRole(int recordRole) throws Exception;
	public List<User> selectUserAll() throws Exception;
	
	public int updateUser(User recordUser) throws Exception;
	public int updateUserLoginTime(int id) throws Exception;
}
