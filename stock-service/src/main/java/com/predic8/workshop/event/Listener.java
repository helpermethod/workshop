package com.predic8.workshop.event;

import com.predic8.workshop.domain.Stock;
import com.predic8.workshop.repository.StockRepository;
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
	private final StockRepository stockRepository;

	@KafkaHandler
	public void listen(@Payload ArticleEvent articleEvent, @Header(RECEIVED_MESSAGE_KEY) String uuid) {
		switch (articleEvent.getOperation()) {
			case "created":
			case "updated":
				stockRepository.save(new Stock(uuid, articleEvent.getName(), 0L));
				break;
			case "deleted":
				stockRepository.delete(uuid);
		}
	}

	@KafkaHandler
	public void listen(@Payload StockEvent stockEvent, @Header(RECEIVED_MESSAGE_KEY) String uuid) {
		Stock stock = stockRepository.findOne(uuid);
		stock.setQuantity(stockEvent.getStock());
		stockRepository.save(stock);
	}
}