package com.predic8.workshop.service;

import com.predic8.workshop.dto.StockDto;
import com.predic8.workshop.event.StockEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleCommandService {
	private final KafkaTemplate<String, StockEvent> kafkaTemplate;

	public void update(String uuid, StockDto quantityDto) {
		kafkaTemplate.send("articles", uuid, new StockEvent(quantityDto.getStock()));
	}
}