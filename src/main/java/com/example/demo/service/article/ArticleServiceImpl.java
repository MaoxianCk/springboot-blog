package com.example.demo.service.article;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleContent;
import com.example.demo.entity.ArticleInfo;
import com.example.demo.service.BaseService;


/**
 * 文章ServiceImpl类 继承BaseService类 实现 ArticleService接口
 * @author:Maoxian
 */
public class ArticleServiceImpl extends BaseService implements ArticleService {
	@Override
	public void addArticle(Article article) {
		try {

			int infoId = articleInfoDaoImpl.insertArticleInfo(article.getArticleInfo());
			article.getArticleContent().setArticleInfoId(infoId);
			articleContentDaoImpl.insertArticleContent(article.getArticleContent());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	public void updateArticle(Article article) {
		try {

			articleInfoDaoImpl.updateArticleInfo(article.getArticleInfo());
			articleContentDaoImpl.updateArticleContent(article.getArticleContent());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article findArticle(int articleInfoId) {
		Article article = null;
		try {

			article = new Article(articleInfoDaoImpl.selectArticleInfoById(articleInfoId),
					articleContentDaoImpl.selectArticleContentByArticleInfoId(articleInfoId));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public ArticleInfo findArticleInfo(int articleInfoId) {
		ArticleInfo articleInfo = null;
		try {

			articleInfo = articleInfoDaoImpl.selectArticleInfoById(articleInfoId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleInfo;
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
							list.add(new Article(info, it.next()));
						}
						it.remove();
					}
				}
				if (isRepeat == false) {
					list.add(new Article(info, articleContentDaoImpl.selectArticleContentByArticleInfoId(info.getId())));
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
				list.add(new Article(info, articleContentDaoImpl.selectArticleContentByArticleInfoId(info.getId())));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ArticleInfo> findArticleInfos() {
		List<ArticleInfo> list = new ArrayList<ArticleInfo>();
		try {
			list = articleInfoDaoImpl.selectArticleInfoAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
