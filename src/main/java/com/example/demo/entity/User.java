package com.example.demo.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户表 user_account表 实体类
 * 
 * @author:Maoxian
 * @creat:2019-01-21 13:50
 */
public class User {
	// 账号ID
	private int id;
	// 账号
	private String account;
	// 密码
	private String password;
	// 昵称
	private String name;
	// 用户组 1为超管、2为普管、3游客
	private int role;
	// 上次登录时间
	private Timestamp lastLoginTime;

	public User(int id, String account, String password, String name, int role, Timestamp lastLoginTime) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.role = role;
		this.lastLoginTime = lastLoginTime;
	}

	public User(String name, String account, String password) {
		this.id = 0;
		this.account = account;
		this.password = password;
		this.name = name;
		this.role = 3;
		this.lastLoginTime = null;
	}

	public User(String account, String password) {
		this.id = 0;
		this.account = account;
		this.password = password;
		this.name = null;
		this.role = 3;
		this.lastLoginTime = null;
	}

	public User() {
		this.id = 0;
		this.account = null;
		this.password = null;
		this.name = null;
		this.role = 3;
		this.lastLoginTime = null;
	}

	public void printUserInfo() {
		System.out.println("id:" + getId() + "\taccount:" + getAccount() + "\tpassword:" + getPassword() + "\tname:"
				+ getName() + "\trole:" + getRole()+"\tlastLoginTime:"+getLastLoginTime());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
