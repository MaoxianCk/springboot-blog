package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.article.ArticleInfoDaoImpl;
import com.example.demo.entity.ArticleInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlArticleInfoDaoImplTest {
	@Test
	public void funtionTest() {
		ArticleInfoDaoImpl articleInfoDaoImpl = new ArticleInfoDaoImpl();

		try {
			List<ArticleInfo> _list = null;
			ArticleInfo _articleInfo = null;

			_list = articleInfoDaoImpl.selectArticleInfoAll();
			printArticleInfoList(_list);

			// 插入10条记录 时间为当前时间
			for (int i = 1; i <= 10; i++) {
				articleInfoDaoImpl.insertArticleInfo(
						new ArticleInfo(0, "title " + String.valueOf(i), "summary " + String.valueOf(i), true, i, i));
			}
			// 插入5条记录 时间为当前时间
			for (int i = 6; i <= 10; i++) {
				articleInfoDaoImpl.insertArticleInfo(
						new ArticleInfo(0, "title " + String.valueOf(i), "summary " + String.valueOf(i), true, i, i));
			}
			_list = articleInfoDaoImpl.selectArticleInfoAll();
			printArticleInfoList(_list);

			// 删除id为9的记录
			articleInfoDaoImpl.deleteArticleInfoById(9);
			_list = articleInfoDaoImpl.selectArticleInfoAll();
			printArticleInfoList(_list);

			// 更新id 3 的记录
			ArticleInfo recordArticleInfo = new ArticleInfo(3, "title updated", "summary updated", false, 99, 99);
			articleInfoDaoImpl.updateArticleInfo(recordArticleInfo);
			_list = articleInfoDaoImpl.selectArticleInfoAll();
			printArticleInfoList(_list);

			// 查找测试...
			_articleInfo = articleInfoDaoImpl.selectArticleInfoById(3);
			printArticleInfo(_articleInfo);
			
			_articleInfo = articleInfoDaoImpl.selectArticleInfoByCommentId(3);
			printArticleInfo(_articleInfo);
			
			_articleInfo = articleInfoDaoImpl.selectArticleInfoByArticleContentId(3);
			printArticleInfo(_articleInfo);

			_list = articleInfoDaoImpl.selectArticleInfoByTitle("up");
			printArticleInfoList(_list);
			
			_list = articleInfoDaoImpl.selectArticleInfoBySummaryParts("up");
			printArticleInfoList(_list);

			_list = articleInfoDaoImpl.selectArticleInfoByIsTop(false);
			printArticleInfoList(_list);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printArticleInfoList(List<ArticleInfo> list) {
		for (ArticleInfo articleInfo : list) {
			articleInfo.printArticleInfo();
		}
		System.out.println();
	}

	private void printArticleInfo(ArticleInfo articleInfo) {
		articleInfo.printArticleInfo();
		System.out.println();
	}
}
