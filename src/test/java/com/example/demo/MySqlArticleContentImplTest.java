package com.example.demo;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.article.ArticleContentDaoImpl;
import com.example.demo.entity.ArticleContent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlArticleContentImplTest {
	@Test
	public void funtionTest() {
		ArticleContentDaoImpl articleContentDaoImpl = new ArticleContentDaoImpl();

		try {
			List<ArticleContent> _list = null;
			ArticleContent _articleContent = null;

			_list = articleContentDaoImpl.selectArticleContentAll();
			printArticleContentList(_list);
			
			//插入10条记录 时间为当前时间
			for(int i=1;i<=10;i++) {
				articleContentDaoImpl.insertArticleContent(new ArticleContent(0, "content "+String.valueOf(i) , i));
			}
			//插入5条记录 时间为当前时间
			for(int i=6;i<=10;i++) {
				articleContentDaoImpl.insertArticleContent(new ArticleContent(0, "content "+String.valueOf(i), i));
			}
			_list = articleContentDaoImpl.selectArticleContentAll();
			printArticleContentList(_list);
			
			//删除id为9的记录
			articleContentDaoImpl.deleteArticleContentById(9);
			_list = articleContentDaoImpl.selectArticleContentAll();
			printArticleContentList(_list);
			
			//更新id 3 的记录 ，结果应只变更content & modified_time
			ArticleContent recordArticleContent =new ArticleContent(3,"content updated" ,new Timestamp(915123661),new Timestamp(915123661), 99);
			articleContentDaoImpl.updateArticleContent(recordArticleContent);
			_list = articleContentDaoImpl.selectArticleContentAll();
			printArticleContentList(_list);
			
			//查找测试...
			_articleContent=articleContentDaoImpl.selectArticleContentByArticleInfoId(0);
			printArticleContent(_articleContent);
			
			_articleContent=articleContentDaoImpl.selectArticleContentById(0);
			printArticleContent(_articleContent);

			_list=articleContentDaoImpl.selectArticleContentByContentParts("cos");
			printArticleContentList(_list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printArticleContentList(List<ArticleContent> list) {
		for (ArticleContent articleContent : list) {
			articleContent.printArticleContentInfo();
		}
		System.out.println();
	}

	private void printArticleContent(ArticleContent articleContent) {
		articleContent.printArticleContentInfo();
		System.out.println();
	}

}