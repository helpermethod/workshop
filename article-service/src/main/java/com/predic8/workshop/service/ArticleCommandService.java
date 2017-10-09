package com.predic8.workshop.service;

import com.predic8.workshop.dto.ArticleDto;
import com.predic8.workshop.event.ArticleEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleCommandService {
	private final KafkaTemplate<String, Object> kafkaTemplate;

	public void save(String uuid, ArticleDto articleDto) {
		kafkaTemplate.send("articles", uuid, new ArticleEvent("created", articleDto.getName(), articleDto.getDescription(), articleDto.getPrice()));
	}

	public void update(String uuid, ArticleDto articleDto) {
		kafkaTemplate.send("articles", uuid, new ArticleEvent("updated", articleDto.getName(), articleDto.getDescription(), articleDto.getPrice()));
	}

	public void delete(String uuid) {
		kafkaTemplate.send("articles", uuid, new ArticleEvent("deleted", null, null, null));
	}
}