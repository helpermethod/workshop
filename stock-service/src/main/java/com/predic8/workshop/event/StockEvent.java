package com.predic8.workshop.event;

import lombok.Data;

@Data
public class StockEvent implements Event {
	private final Long stock;
}