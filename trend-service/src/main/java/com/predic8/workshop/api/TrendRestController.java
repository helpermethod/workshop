package com.predic8.workshop.api;

import com.predic8.workshop.domain.Trend;
import com.predic8.workshop.repository.TrendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/trends")
@RestController
public class TrendRestController {
	private final TrendRepository trendRepository;

	@GetMapping("/{uuid}")
	public Iterable<Trend> index(@PathVariable String uuid) {
		return trendRepository.findTrends(uuid);
	}
}