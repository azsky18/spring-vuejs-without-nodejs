package com.ingyeo.vuejs.article.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingyeo.vuejs.article.domain.Article;
import com.ingyeo.vuejs.article.service.ArticleService;


@RestController
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@GetMapping("/api/articles")
	public Page<Article> getArticles(@PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable) {
		return articleService.findAll(pageable);
	}

	@GetMapping("/api/articles/{id}")
	public Optional<Article> getArticle(@PathVariable Long id) {
		return articleService.findById(id);
	}

	@PostMapping("/api/article")
	public Article postArticle(@RequestBody @Valid Article article) {
		return articleService.save(article);
	}
}
