package com.example.demo.service;

import com.example.demo.dao.article.ArticleCommentDaoImpl;
import com.example.demo.dao.article.ArticleContentDaoImpl;
import com.example.demo.dao.article.ArticleInfoDaoImpl;
import com.example.demo.dao.user.UserDaoImpl;

/**
 * 服务类基类 包含DaoImpl类对象
 * @author:Maoxian
 */
public class BaseService {

	// ArticleDaoImpl
	public ArticleInfoDaoImpl articleInfoDaoImpl;
	public ArticleContentDaoImpl articleContentDaoImpl;
	public ArticleCommentDaoImpl articleCommentDaoImpl;

	// UserDaoImpl;
	public UserDaoImpl userDaoImpl;

	public BaseService() {
		articleInfoDaoImpl = new ArticleInfoDaoImpl();
		articleContentDaoImpl = new ArticleContentDaoImpl();
		articleCommentDaoImpl = new ArticleCommentDaoImpl();
		userDaoImpl = new UserDaoImpl();
	}
}
