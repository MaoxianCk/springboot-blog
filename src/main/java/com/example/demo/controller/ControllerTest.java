package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControllerTest {
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("");
	}
	@RequestMapping("/Home")
	public ModelAndView home() {
		return new ModelAndView("Game");
	}
}
