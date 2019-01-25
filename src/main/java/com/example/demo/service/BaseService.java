package com.example.demo.service;

import com.example.demo.dao.article.ArticleCommentDaoImpl;
import com.example.demo.dao.article.ArticleContentDaoImpl;
import com.example.demo.dao.article.ArticleInfoDaoImpl;
import com.example.demo.dao.user.UserDaoImpl;

public class BaseService {
	
	// ArticleDaoImpl
	public static ArticleInfoDaoImpl articleInfoDaoImpl;
	public static ArticleContentDaoImpl articleContentDaoImpl;
	public static ArticleCommentDaoImpl articleCommentDaoImpl;
	
	// UserDaoImpl;
	public static UserDaoImpl userDaoImpl;

}
