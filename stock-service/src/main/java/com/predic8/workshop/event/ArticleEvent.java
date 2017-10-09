package com.predic8.workshop.event;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

import java.math.BigDecimal;

@Data
public class ArticleEvent implements Event {
	private String operation;
	private String name;
	private String description;
	private BigDecimal price;
}