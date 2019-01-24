package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.user.UserDaoImpl;
import com.example.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlUserDaoImplTest {
	@Test
	public void funtionTest() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();

		try {
			List<User> _list = null;
			User _user = null;

			// 打印所有记录
			_list = userDaoImpl.selectUserAll();
			printUserList(_list);

			// 新增10条记录 1-10
			for (int i = 1; i <= 10; i++) {
				User user = new User(0, String.valueOf(i), String.valueOf(i), String.valueOf(i), 1);
				userDaoImpl.insertUser(user);
			}
			// 增加3条重复记录 7-9
			for (int i = 7; i <= 9; i++) {
				User user = new User(0, String.valueOf(i), String.valueOf(i), String.valueOf(i), 1);
				userDaoImpl.insertUser(user);
			}
			// 增加4条 role为2 重复记录 5-8
			for (int i = 5; i <= 8; i++) {
				User user = new User(0, String.valueOf(i), String.valueOf(i), String.valueOf(i), 2);
				userDaoImpl.insertUser(user);
			}

			// 打印所有记录
			_list = userDaoImpl.selectUserAll();
			printUserList(_list);

			// 打印account为7的记录
			_user = userDaoImpl.selectUserByAccount("7");
			printUser(_user);

			// 打印name为8的记录
			_list = userDaoImpl.selectUserByName("8");
			printUserList(_list);

			// 打印role为2的记录
			_list = userDaoImpl.selectUserByRole(2);
			printUserList(_list);

			// 删除id为3的记录
			userDaoImpl.deleteUserById(3);
			_list = userDaoImpl.selectUserAll();
			printUserList(_list);
			
			// 更新id为2的记录中 为 2,"99","99","99",3
			User updateUser=userDaoImpl.selectUserById(2);
			updateUser.setAccount("99");
			updateUser.setPassword("99");
			updateUser.setName("99");
			updateUser.setRole(3);
			userDaoImpl.updateUser(updateUser);
			_list = userDaoImpl.selectUserAll();
			printUserList(_list);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printUserList(List<User> list) {
		for (User user : list) {
			user.printUserInfo();
		}
		System.out.println();
	}

	private void printUser(User user) {
		user.printUserInfo();
		System.out.println();
	}
}
