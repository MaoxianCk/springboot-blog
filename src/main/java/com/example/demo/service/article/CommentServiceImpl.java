package com.example.demo.service.article;

import java.util.List;

import com.example.demo.entity.ArticleComment;
import com.example.demo.service.BaseService;

public class CommentServiceImpl extends BaseService implements CommentService {

	@Override
	public void addComment(ArticleComment comment) {
		try {

			articleCommentDaoImpl.insertArticleComment(comment);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteComment(int articleCommentId) {
		try {

			articleCommentDaoImpl.deleteArticleCommentById(articleCommentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCommentByArticleInfoId(int articleInfoId) {
		try {

			articleCommentDaoImpl.deleteArticleCommentByArticleInfoId(articleInfoId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateArticle(ArticleComment comment) {
		try {

			articleCommentDaoImpl.updateArticleComment(comment);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArticleComment findComment(int id) {
		ArticleComment articleComment = null;
		try {

			articleComment = articleCommentDaoImpl.selectArticleCommentById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleComment;
	}

	@Override
	public List<ArticleComment> findComments(int articleInfoId) {
		List<ArticleComment> list = null;
		try {

			list = articleCommentDaoImpl.selectArticleCommentByArticleInfoId(articleInfoId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ArticleComment> findComments() {
		List<ArticleComment> list = null;
		try {

			articleCommentDaoImpl.selectArticleCommentAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
