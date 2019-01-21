package com.example.demo.dao.article;

import java.util.Date;
import java.util.List;

import com.example.demo.dao.BaseDao;
import com.example.demo.entity.ArticleContent;

public class ArticleContentDaoImpl extends BaseDao implements ArticleContentDao {

	@Override
	public boolean insertArticleContent(ArticleContent recordArticleContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticleContentById(int recordId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArticleContent selectArticleContentById(int recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleContent selectArticleContentByArticleInfoId(int recordArticleInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleContent> selectArticleContentByContentParts(String recordContentParts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleContent> selectArticleContentByCreateTime(Date recordCreateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleContent> selectArticleContentByModifiedTime(Date recordModifiedTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateArticleContent(ArticleContent recordarticleContent) {
		// TODO Auto-generated method stub
		return false;
	}

}
