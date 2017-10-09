package com.predic8.workshop.service;

import com.predic8.workshop.dto.QuantityDto;
import com.predic8.workshop.event.QuantityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleCommandService {
	private final KafkaTemplate<String, QuantityEvent> kafkaTemplate;

	public void update(String uuid, QuantityDto quantityDto) {
		kafkaTemplate.send("articles", uuid, new QuantityEvent(quantityDto.getQuantity()));
	}
}