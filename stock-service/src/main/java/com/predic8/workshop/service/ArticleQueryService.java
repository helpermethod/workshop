package com.predic8.workshop.service;

import com.predic8.workshop.domain.Article;
import com.predic8.workshop.error.NotFoundException;
import com.predic8.workshop.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleQueryService {
	private final ArticleRepository articleRepository;

	@GetMapping
	public List<Article> index() {
		return articleRepository.findAll();
	}

	@GetMapping
	public Article show(@PathVariable String uuid) {
		return Optional.ofNullable(articleRepository.findOne(uuid)).orElseThrow(NotFoundException::new);
	}
}
