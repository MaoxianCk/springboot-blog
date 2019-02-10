package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

/**
 * 登录控制器 负责账号的登录注册
 * 
 * @author:Maoxian
 */
@RestController
@RequestMapping("/api/login")
public class LoginController extends BaseController {
	// 登录
	@PostMapping("/signIn")
	public Map<String, String> signIn(@RequestBody User user, HttpServletResponse response) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: signIn");

		User dbUser = userService.findUser(user.getAccount());
		Map<String, String> map = new HashMap<String, String>();
		if ((dbUser == null) || !(dbUser.getPassword().equals(user.getPassword()))) {
			map.put("msg", "账号不存在或密码错误");
		} else {
			map.put("msg", "登录成功");
			map.put("role", String.valueOf(dbUser.getRole()));

			Cookie cookie = new Cookie("account", user.getAccount());
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
			userService.setLoginTime(dbUser.getId());
		}

		return map;
	}

	// 注册
	@PostMapping("/signUp")
	public Map<String, String> signUp(@RequestBody User user, HttpServletResponse response) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: signUp");

		User dbUser = userService.findUser(user.getAccount());
		Map<String, String> map = new HashMap<String, String>();
		if (dbUser != null) {
			map.put("msg", "账号已存在");
		} else {
			dbUser = new User(0, user.getAccount(), user.getPassword(), user.getName(), 3,
					new Timestamp(System.currentTimeMillis()));
			userService.addUser(dbUser);
			map.put("msg", "注册成功");
			map.put("role", "3");

			dbUser = userService.findUser(user.getAccount());
			Cookie cookie = new Cookie("account", user.getAccount());
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
			userService.setLoginTime(dbUser.getId());
		}

		return map;
	}
}
