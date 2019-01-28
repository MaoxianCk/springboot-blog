package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ArticleInfo;

@RestController
@RequestMapping("/api")
public class ForeController extends BaseController {
	
	//获取所有文章
	@GetMapping("/article/showAllArticleInfo")
	public List<ArticleInfo> showAllArticleInfo() {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis())+"  请求接口: showAllArticleInfo()");
		List<ArticleInfo> list=articleService.findArticleInfos();
		return list;
	}
}
