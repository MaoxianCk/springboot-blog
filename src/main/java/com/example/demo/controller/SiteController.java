package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class SiteController {
	@GetMapping("/index")
	public String index(){
	return "home"; //当浏览器输入/index时，会返回 /static/home.html的页面
	}
}
