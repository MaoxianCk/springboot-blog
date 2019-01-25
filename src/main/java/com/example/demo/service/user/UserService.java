package com.example.demo.service.user;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	public void addUser(User user);
	public void deleteUser(int userId);
	public void updateUser(User user);
	public User findUser(int id);
	public List<User> findUsers(String name);
	public List<User> findUsers(int role);
}
