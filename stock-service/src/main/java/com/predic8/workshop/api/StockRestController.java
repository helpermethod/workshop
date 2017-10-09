package com.predic8.workshop.api;


import com.predic8.workshop.domain.Stock;
import com.predic8.workshop.dto.StockDto;
import com.predic8.workshop.service.StockCommandService;
import com.predic8.workshop.service.StockQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/stocks")
@RestController
public class StockRestController {
	private final StockQueryService stockQueryService;
	private final StockCommandService stockCommandService;

	@GetMapping
	public List<Stock> index() {
		return stockQueryService.index();
	}

	@GetMapping("/{uuid}")
	public Stock show(@PathVariable String uuid) {
		return stockQueryService.show(uuid);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<Void> update(@PathVariable String uuid, @RequestBody StockDto quantity) {
		stockCommandService.update(uuid, quantity);

		return ResponseEntity.noContent().build();
	}
}