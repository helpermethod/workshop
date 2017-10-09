package com.predic8.workshop.service;

import com.predic8.workshop.domain.Stock;
import com.predic8.workshop.error.NotFoundException;
import com.predic8.workshop.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StockQueryService {
	private final StockRepository stockRepository;

	@GetMapping
	public List<Stock> index() {
		return stockRepository.findAll();
	}

	@GetMapping
	public Stock show(@PathVariable String uuid) {
		return Optional.ofNullable(stockRepository.findOne(uuid)).orElseThrow(NotFoundException::new);
	}
}
