package com.ingyeo.vuejs.article.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ingyeo.vuejs.article.domain.Article;
import com.ingyeo.vuejs.article.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository repository;

	public Page<Article> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Article save(Article article) {
		return repository.save(article);
	}

	public Optional<Article> findById(Long id) {
		return repository.findById(id);
	}
}
