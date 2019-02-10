package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 * @author:Maoxian
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截规则：拦截/admin以下所有界面 
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/admin/**");
	}
}
