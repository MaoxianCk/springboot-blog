package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.article.ArticleCommentDaoImpl;
import com.example.demo.entity.ArticleComment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlArticleCommentImplTest {
	@Test
	public void funtionTest() {
		ArticleCommentDaoImpl articleCommentDaoImpl = new ArticleCommentDaoImpl();

		try {
			List<ArticleComment> _list = null;
			ArticleComment _articleComment = null;

			_list = articleCommentDaoImpl.selectArticleCommentAll();
			printArticleCommentList(_list);
			
			//插入10条记录 时间为当前时间
			for(int i=1;i<=10;i++) {
				articleCommentDaoImpl.insertArticleComment(new ArticleComment(0, "content "+String.valueOf(i) , String.valueOf(i), true, i));
			}
			//插入5条记录 时间为当前时间
			for(int i=6;i<=10;i++) {
				articleCommentDaoImpl.insertArticleComment(new ArticleComment(0, "content "+String.valueOf(i), String.valueOf(i), true, i));
			}
			_list = articleCommentDaoImpl.selectArticleCommentAll();
			printArticleCommentList(_list);
			
			//删除id为9的记录
			articleCommentDaoImpl.deleteArticleCommentById(9);
			_list = articleCommentDaoImpl.selectArticleCommentAll();
			printArticleCommentList(_list);
			
			//更新id 3 的记录 ，结果应只变更iseffective
			ArticleComment recordArticleComment =new ArticleComment(3, "context updated" , "updated", false, 99);
			articleCommentDaoImpl.updateArticleComment(recordArticleComment);
			_list = articleCommentDaoImpl.selectArticleCommentAll();
			printArticleCommentList(_list);
			
			//查找测试...
			_articleComment=articleCommentDaoImpl.selectArticleCommentByArticleInfoId(3);
			printArticleComment(_articleComment);
			
			_articleComment=articleCommentDaoImpl.selectArticleCommentById(3);
			printArticleComment(_articleComment);

			_list=articleCommentDaoImpl.selectArticleCommentByContentParts("content");
			printArticleCommentList(_list);
			
			_list=articleCommentDaoImpl.selectArticleCommentByIsEffective(false);
			printArticleCommentList(_list);
			
			_list=articleCommentDaoImpl.selectArticleCommentByName("8");
			printArticleCommentList(_list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printArticleCommentList(List<ArticleComment> list) {
		for (ArticleComment articleComment : list) {
			articleComment.printArticleCommentInfo();
		}
		System.out.println();
	}

	private void printArticleComment(ArticleComment articleComment) {
		articleComment.printArticleCommentInfo();
		System.out.println();
	}

}
