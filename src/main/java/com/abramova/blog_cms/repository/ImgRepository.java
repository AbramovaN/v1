package com.abramova.blog_cms.repository;

import com.abramova.blog_cms.entity.Article;
import com.abramova.blog_cms.entity.Img;
import org.springframework.data.repository.CrudRepository;

public interface ImgRepository extends CrudRepository<Img, Integer> {
    Iterable<Img> findAllByArticle(Article id);
}
