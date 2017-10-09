package com.predic8.workshop.event;

import com.predic8.workshop.domain.Article;
import com.predic8.workshop.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_MESSAGE_KEY;

@RequiredArgsConstructor
@Service
@KafkaListener(topics = "articles")
public class Listener {
	private final ArticleRepository articleRepository;

	@KafkaHandler
	public void listen(@Payload ArticleEvent articleEvent, @Header(RECEIVED_MESSAGE_KEY) String uuid) {
		switch (articleEvent.getOperation()) {
			case "created":
			case "updated":
				articleRepository.save(new Article(uuid, 0L));
				break;
			case "deleted":
				articleRepository.delete(uuid);
		}
	}

	@KafkaHandler
	public void listen(@Payload StockEvent stockEvent, @Header(RECEIVED_MESSAGE_KEY) String uuid) {
		Article article = articleRepository.findOne(uuid);
		article.setQuantity(stockEvent.getStock());
		articleRepository.save(article);
	}
}