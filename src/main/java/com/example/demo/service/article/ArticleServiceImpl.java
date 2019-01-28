package com.example.demo.service.article;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleContent;
import com.example.demo.entity.ArticleInfo;
import com.example.demo.service.BaseService;

public class ArticleServiceImpl extends BaseService implements ArticleService {

	@Override
	public void addArticle(ArticleInfo info, ArticleContent content) {
		try {

			articleInfoDaoImpl.insertArticleInfo(info);
			articleContentDaoImpl.insertArticleContent(content);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteArticle(int articleInfoId) {
		try {

			// 删除对应文章信息表、文章内容表、评论表中对应记录
			articleInfoDaoImpl.deleteArticleInfoById(articleInfoId);
			articleContentDaoImpl.deleteArticleContentByArticleInfoId(articleInfoId);
			articleCommentDaoImpl.deleteArticleCommentByArticleInfoId(articleInfoId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateArticle(ArticleInfo info, ArticleContent content) {
		try {

			articleInfoDaoImpl.updateArticleInfo(info);
			articleContentDaoImpl.updateArticleContent(content);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article findArticle(int articleInfoId) {
		Article article = null;
		try {

			article = new Article(articleInfoDaoImpl.selectArticleInfoById(articleInfoId),
					articleContentDaoImpl.selectArticleContentByArticleInfoId(articleInfoId),
					articleCommentDaoImpl.selectArticleCommentByArticleInfoId(articleInfoId));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public List<Article> findArticles(String title, String contentPart) {
		List<Article> list = new ArrayList<Article>();
		try {

			List<ArticleInfo> infoList = articleInfoDaoImpl.selectArticleInfoByTitle(title);
			List<ArticleContent> contentList = articleContentDaoImpl.selectArticleContentByContentParts(contentPart);

			// 查重并加入list
			for (ArticleInfo info : infoList) {
				boolean isRepeat = false;
				Iterator<ArticleContent> it = contentList.iterator();
				while (it.hasNext()) {
					if (info.getId() == it.next().getArticleInfoId()) {
						if (isRepeat == false) {
							isRepeat = true;
							list.add(new Article(info, it.next(),
									articleCommentDaoImpl.selectArticleCommentByArticleInfoId(info.getId())));
						}
						it.remove();
					}
				}
				if (isRepeat == false) {
					list.add(new Article(info, articleContentDaoImpl.selectArticleContentByArticleInfoId(info.getId()),
							articleCommentDaoImpl.selectArticleCommentByArticleInfoId(info.getId())));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Article> findArticles() {
		List<Article> list = new ArrayList<Article>();
		try {

			List<ArticleInfo> infoList = articleInfoDaoImpl.selectArticleInfoAll();
			for (ArticleInfo info : infoList) {
				list.add(new Article(info, articleContentDaoImpl.selectArticleContentByArticleInfoId(info.getId()),
						articleCommentDaoImpl.selectArticleCommentByArticleInfoId(info.getId())));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<ArticleInfo> findArticleInfos(){
		List<ArticleInfo> list = new ArrayList<ArticleInfo>();
		try {
			list = articleInfoDaoImpl.selectArticleInfoAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
