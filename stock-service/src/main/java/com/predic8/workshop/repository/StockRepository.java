package com.predic8.workshop.repository;

import com.predic8.workshop.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
}