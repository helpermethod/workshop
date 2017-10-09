package com.predic8.workshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

import static lombok.AccessLevel.PROTECTED;

// see https://github.com/rzwitserloot/lombok/issues/1389
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Getter
@Setter
public class Stock {
	@Id
	private String uuid;
	private String name;
	private Long quantity;
}