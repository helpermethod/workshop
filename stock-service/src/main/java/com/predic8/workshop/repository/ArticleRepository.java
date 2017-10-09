package com.predic8.workshop.repository;

import com.predic8.workshop.domain.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}