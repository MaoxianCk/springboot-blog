package com.example.demo.dao.user;

import java.util.List;

import com.example.demo.entity.User;


public interface UserDao {
	/* 插入 */
	public int insertUser(User recordUser) throws Exception;
	
	
	/* 删除 */
	public int deleteUserById(int recordId) throws Exception;
	
	/* 查找 */
	public User selectUserById(int recordId) throws Exception;
	public User selectUserByAccount(String recordAccount) throws Exception;
	public List<User> selectUserByName(String recordName) throws Exception;	
	public List<User> selectUserByRole(int recordRole) throws Exception;
	//根据最后登录时间返回所有用户
	public List<User> selectUserAll() throws Exception;
	
	/* 修改 */
	public int updateUser(User recordUser) throws Exception;
	public int updateUserLoginTime(int id) throws Exception;
}
