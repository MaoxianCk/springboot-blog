package com.example.demo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.ArticleInfo;
import com.example.demo.service.article.ArticleServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlArticleServiceTest {
	@Test
	public void funtionTest() {
		ArticleServiceImpl articleServiceImpl = new ArticleServiceImpl();

			List<ArticleInfo> infoList=null;
			infoList = articleServiceImpl.findArticleInfos();

	}
	
	private void printArticleInfoList(List<ArticleInfo> list) {
		for(ArticleInfo ele:list) {
			ele.printArticleInfo();
		}
	}
}
