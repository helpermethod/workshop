package com.predic8.workshop.api;


import com.predic8.workshop.domain.Article;
import com.predic8.workshop.dto.QuantityDto;
import com.predic8.workshop.service.ArticleCommandService;
import com.predic8.workshop.service.ArticleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/articles")
@RestController
public class ArticleRestController {
	private final ArticleQueryService articleQueryService;
	private final ArticleCommandService articleCommandService;

	@GetMapping
	public List<Article> index() {
		return articleQueryService.index();
	}

	@GetMapping("/{uuid}")
	public Article show(@PathVariable String uuid) {
		return articleQueryService.show(uuid);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<Void> update(@PathVariable String uuid, @RequestBody QuantityDto quantity) {
		articleCommandService.update(uuid, quantity);

		return ResponseEntity.noContent().build();
	}
}