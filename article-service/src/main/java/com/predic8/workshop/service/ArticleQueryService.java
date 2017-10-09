package com.predic8.workshop.service;

import com.predic8.workshop.entity.Article;
import com.predic8.workshop.error.NotFoundException;
import com.predic8.workshop.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleQueryService {
	private final ArticleRepository articleRepository;

	public List<Article> index() {
		return articleRepository.findAll();
	}

	public Article show(String uuid) {
		return Optional.ofNullable(articleRepository.findOne(uuid)).orElseThrow(NotFoundException::new);
	}
}
