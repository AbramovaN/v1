package com.abramova.blog_cms.repository;

import com.abramova.blog_cms.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository  extends CrudRepository<Article, Integer> {
}
