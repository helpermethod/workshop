package com.predic8.workshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

import static lombok.AccessLevel.PROTECTED;

// see https://github.com/rzwitserloot/lombok/issues/1389
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Article {
	@Id
	private String uuid;
	private String name;
	private String description;
	private BigDecimal price;
}