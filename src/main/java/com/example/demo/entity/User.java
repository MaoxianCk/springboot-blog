package com.example.demo.entity;

/**
 * 用户表 user_account表 实体类
 * @author:Maoxian
 * @creat:2019-01-21 13:50
 */
public class User {
	//账号ID
	private int id;
	//账号
	private String account;
	//密码
	private String password;
	//昵称
	private String name;
	//用户组 1为超管、2为普管、3游客
	private int role;
	
	public User(int id, String account, String password, String name, int role) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	
	public void printUserInfo() {
		System.out.println("id:" + getId() + "\taccount:" + getAccount() + "\tpassword:"
				+ getPassword() + "\tname:" + getName() + "\trole:" + getRole());
	}

	public int getId() {
		return id;
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
	
	
}
