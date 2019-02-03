package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleComment;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/api/admin")
public class BackController extends BaseController {
	// 获取所有用户信息
	@GetMapping("/getAllUser")
	public List<User> showAllUser() {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: getAllUser");
		List<User> list = userService.findUsers();
		return list;
	}

	// 获取评论
	@GetMapping("/getComment/{id}")
	public ArticleComment showArticleComment(@PathVariable int id) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: getComment");
		ArticleComment comment = commentService.findComment(id);
		return comment;
	}

	// 获取所有评论
	@GetMapping("/getAllComment")
	public List<ArticleComment> showAllArticleComment() {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: getAllComment");
		List<ArticleComment> list = commentService.findComments();
		return list;
	}

	// 删除评论
	@DeleteMapping("/deleteComment/{id}")
	public String deleteComment(@PathVariable int id) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: deleteComment(" + id + ")");
		commentService.deleteComment(id);
		return null;
	}

	// 删除文章
	@DeleteMapping("/deleteArticle/{infoId}")
	public String deleteArticle(@PathVariable int infoId) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: deleteArticle(" + infoId + ")");
		articleService.deleteArticle(infoId);
		return null;
	}

	// 增加文章
	@PostMapping("/addArticle")
	public String addArticle(@RequestBody Article article) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: addArticle");
		articleService.addArticle(article);
		return null;
	}

	// 更新文章
	@PutMapping("/updateArticle/{infoId}")
	public String updateArticle(@PathVariable int infoId, @RequestBody Article article) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: updateArticle");
		Article dbArticle = articleService.findArticle(infoId);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dbArticle.getArticleInfo().setTitle(article.getArticleInfo().getTitle());
		dbArticle.getArticleInfo().setSummary(article.getArticleInfo().getSummary());
		dbArticle.getArticleInfo().setModifiedTime(timestamp);
		dbArticle.getArticleInfo().setIsTop(article.getArticleInfo().getIsTop());

		dbArticle.getArticleContent().setContent(article.getArticleContent().getContent());
		dbArticle.getArticleContent().setModifiedTime(timestamp);
		articleService.updateArticle(dbArticle);
		return null;
	}

	// 更新评论
	@PutMapping("/updateComment/{id}")
	public String updateComment(@PathVariable int id, @RequestBody ArticleComment comment) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: updateComment");
		ArticleComment dbComment = commentService.findComment(id);
		dbComment.setIsEffective(comment.getIsEffective());
		commentService.updateArticle(dbComment);
		return null;
	}

	// 删除用户
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: deleteUser");
		userService.deleteUser(id);
		return null;
	}

	// 获取用户
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: getUser");
		User user = userService.findUser(id);
		return user;
	}

	// 更新用户
	@PutMapping("/updateUser/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User user, HttpServletRequest request) {
		System.out.println("=========================================");
		System.out.println(new Timestamp(System.currentTimeMillis()) + "  请求接口: updateUser");

		// 验证操作权限
		Cookie cookies[] = request.getCookies();
		String account = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("account")) {
				account = cookie.getValue();
			}
		}
		if (!account.equals("")) {
			User conUser = userService.findUser(account);
			if (conUser != null) {
				if (conUser.getRole() == 1) {
					User dbUser = userService.findUser(id);
					int newRole = user.getRole();
					if (newRole == 3 || newRole == 2) {
						dbUser.setRole(newRole);
						userService.updateUser(dbUser);
						return null;
					}
				}
			}
		}

		return "权限不足";
	}

	// 检查cookie中用户组权限
	@GetMapping("/checkUser")
	public boolean checkUser(HttpServletRequest request) {
		// 验证操作权限
		Cookie cookies[] = request.getCookies();
		String account = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("account")) {
				account = cookie.getValue();
			}
		}
		if (!account.equals("")) {
			User conUser = userService.findUser(account);
			if (conUser != null && conUser.getRole() == 1) {
				return true;
			}
		}
		return false;
	}

}
