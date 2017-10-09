package com.predic8.workshop.event;

import lombok.Data;

@Data
public class QuantityEvent implements Event {
	private final Long quantity;
}