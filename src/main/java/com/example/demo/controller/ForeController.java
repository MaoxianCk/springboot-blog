package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleComment;
import com.example.demo.entity.ArticleInfo;

@RestController
@RequestMapping("/api")
public class ForeController extends BaseController {
	//获取文章信息
		@GetMapping("/article/getArticleInfo/{id}")
		public ArticleInfo showArticleInfo(@PathVariable int id) {
			System.out.println("=========================================");
			System.out.println(new Timestamp(System.currentTimeMillis())+"  请求接口: getArticleInfo("+id+")");
			ArticleInfo info=articleService.findArticleInfo(id);
			return info;
		}
		
	//获取所有文章信息
	@GetMapping("/article/getAllArticleInfo")
	public List<ArticleInfo> showAllArticleInfo() {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis())+"  请求接口: getAllArticleInfo");
		List<ArticleInfo> list=articleService.findArticleInfos();
		return list;
	}
	
	//获取articleInfoId对应文章
	@GetMapping("/article/getArticle/{id}")
	public Article showArticle(@PathVariable int id) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis())+"  请求接口: getArticle("+id+")");
		Article article=articleService.findArticle(id);
		return article;
	}
	
	//获取articleInfoId对应评论
	@GetMapping("/article/getComment/{id}")
	public List<ArticleComment> showComment(@PathVariable int id) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis())+"  请求接口: getComment("+id+")");
		List<ArticleComment> list = commentService.findComments(id);
		return list;
	}
	
	//获取所有评论
	@GetMapping("/article/getAllComment")
	public List<ArticleComment> showAllArticleComment(){
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis())+"  请求接口: getAllComment");
		List<ArticleComment> list=commentService.findComments();
		return list;
	}
	
	//增加一条评论
	@PostMapping("/article/postComment/{id}")
    public String addArticleComment(@PathVariable int id, @RequestBody ArticleComment articleComment, HttpServletRequest request) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis())+"  请求接口: postComment("+id+")");
		articleComment.setArticleInfoId(id);
        commentService.addComment(articleComment);
        return null;
    }
}
