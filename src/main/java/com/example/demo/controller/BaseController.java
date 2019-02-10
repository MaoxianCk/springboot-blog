package com.example.demo.controller;

import com.example.demo.service.article.ArticleServiceImpl;
import com.example.demo.service.article.CommentServiceImpl;
import com.example.demo.service.user.UserServiceImpl;

/**
 * 控制器基类，包含所有的ServiceImpl实体对象
 * @author:Maoxian
 */
public class BaseController {
	protected final static ArticleServiceImpl articleService = new ArticleServiceImpl();
	protected final static CommentServiceImpl commentService = new CommentServiceImpl();
	protected final static UserServiceImpl userService = new UserServiceImpl();
}
