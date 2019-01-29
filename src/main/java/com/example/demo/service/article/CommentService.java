package com.example.demo.service.article;

import java.util.List;

import com.example.demo.entity.ArticleComment;

public interface CommentService {
	public void addComment(ArticleComment comment);
	public void deleteComment(int articleCommentId);
	public void deleteCommentByArticleInfoId(int articleInfoId);
	public void updateArticle(ArticleComment comment);
	public ArticleComment findComment(int id);
	public List<ArticleComment> findComments(int articleInfoId);
	public List<ArticleComment> findComments();
	
}
