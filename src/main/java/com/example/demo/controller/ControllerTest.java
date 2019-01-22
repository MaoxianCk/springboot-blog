package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.user.UserDaoImpl;
import com.example.demo.entity.User;

@RestController
public class ControllerTest {
	@RequestMapping("/")
	public ModelAndView index() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = null;
		try {
			user = userDaoImpl.selectUserById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null) {
			System.out.println(user.getId() + user.getName());
		}
		return new ModelAndView("Home");
	}
}
