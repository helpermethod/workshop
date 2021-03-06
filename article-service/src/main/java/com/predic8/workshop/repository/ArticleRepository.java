package com.predic8.workshop.repository;

import com.predic8.workshop.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, String> {
}