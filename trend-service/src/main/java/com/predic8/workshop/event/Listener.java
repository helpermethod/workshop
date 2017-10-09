package com.predic8.workshop.event;


import com.predic8.workshop.domain.Key;
import com.predic8.workshop.domain.Trend;
import com.predic8.workshop.repository.TrendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_MESSAGE_KEY;

@RequiredArgsConstructor
@Service
@KafkaListener(topics = "articles")
public class Listener {
	private final TrendRepository articleRepository;

	@KafkaHandler
	public void listen(@Payload ArticleEvent articleEvent, @Header(RECEIVED_MESSAGE_KEY) String uuid) {
		switch (articleEvent.getOperation()) {
			case "created":
			case "updated":
				articleRepository.save(new Trend(new Key(uuid, new Date()), articleEvent.getName(), articleEvent.getPrice()));
		}
	}

	@KafkaHandler
	public void listen(@Payload StockEvent stockEvent, @Header(RECEIVED_MESSAGE_KEY) String uuid) {
		// NOOP
	}
}