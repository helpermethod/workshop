package com.predic8.workshop.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ArticleEvent implements Event {
	private final String operation;
	private final String name;
	private final String description;
	private final BigDecimal price;
}