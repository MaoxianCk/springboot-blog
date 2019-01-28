package com.example.demo.controller;

import com.example.demo.service.article.ArticleServiceImpl;
import com.example.demo.service.article.CommentServiceImpl;
import com.example.demo.service.user.UserServiceImpl;

public class BaseController {
	protected final static ArticleServiceImpl articleService = new ArticleServiceImpl();
	protected final static CommentServiceImpl commentService = new CommentServiceImpl();
	protected final static UserServiceImpl userService = new UserServiceImpl();
}
