package com.example.demo.dao.article;

import java.util.Date;
import java.util.List;

import com.example.demo.dao.BaseDao;
import com.example.demo.entity.ArticleComment;

public class ArticleCommentDaoImpl extends BaseDao implements ArticleCommentDao {

	@Override
	public boolean insertArticleComment(ArticleComment recordArticleComment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticleCommentById(int recordId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArticleComment selectArticleCommentById(int recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleComment selectArticleCommentByArticleInfoId(int recordArticleInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleComment> selectArticleCommentByCreateTime(Date recordCreateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleComment> selectArticleCommentByContentParts(String recordContentParts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleComment> selectArticleCommentByName(String recordName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleComment> selectArticleCommentByIsEffective(boolean recordIsEffective) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateArticleComment(ArticleComment recordArticleComment) {
		// TODO Auto-generated method stub
		return false;
	}

}
