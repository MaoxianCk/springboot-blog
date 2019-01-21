package com.example.demo.dao.article;

import java.util.Date;
import java.util.List;

import com.example.demo.dao.BaseDao;
import com.example.demo.entity.ArticleInfo;

public class ArticleInfoDaoImpl extends BaseDao implements ArticleInfoDao {

	@Override
	public boolean insertArticleInfo(ArticleInfo recordArticleInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticleInfoById(int recordId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArticleInfo selectArticleInfoById(int recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleInfo selectArticleInfoByArticleContentId(int recordArticleContentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleInfo selectArticleInfoByCommentId(int recordCommentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoByTitle(String recordTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoBySummaryParts(String recordSummaryParts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoByIsTop(boolean recordIsTop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoByCreateTime(Date recordCreateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> selectArticleInfoByModifiedTime(Date recordModifiedTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateArticleInfo(ArticleInfo recordArticleInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}
