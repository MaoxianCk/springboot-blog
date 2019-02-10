package com.example.demo.interceptor;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.user.UserServiceImpl;

/**
 * 拦截器
 * 根据用户登录情况拦截后台界面
 * 允许条件 : 当且仅当当前账号权限为管理员 2或1 时 
 * @author:Maoxian
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("==================hander===============");
		UserServiceImpl userService = new UserServiceImpl();
		Cookie cookies[] = request.getCookies();
		String account = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("account")) {
				account = cookie.getValue();
			}
		}
		//System.out.println("Cookie account : " + account);

		if (!account.equals("")) {
			User user = userService.findUser(account);
			if (user != null) {
				if (user.getRole() == 2 || user.getRole() == 1) {
					return true;
				}
			}
		}
		System.out.println("拦截成功");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
