package com.abramova.blog_cms.controller;

import com.abramova.blog_cms.entity.Article;
import com.abramova.blog_cms.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;


@RestController
@RequestMapping("v2")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    private Iterable<Article> getAll() {
        return articleRepository.findAll();
    }

    @GetMapping("{id}")
    private Article getOne(@PathVariable Integer id) {
        return articleRepository.findById(id).orElse(null);
    }

    @PostMapping
    private void addArticle(@RequestParam String header, @RequestParam Timestamp dateOfCreationYYMMDDHHMMSS,
                            @RequestParam Timestamp dateOfEditYYMMDDHHMMSS, @RequestParam String body, @RequestParam String autor) {
        articleRepository.save(new Article(header, dateOfCreationYYMMDDHHMMSS, dateOfEditYYMMDDHHMMSS, body, autor));
    }

    @PutMapping("{id}")
    private void updateArticle(@PathVariable Integer id, @RequestParam String header, @RequestParam Timestamp dateOfCreationYYMMDDHHMMSS,
                               @RequestParam Timestamp dateOfEditYYMMDDHHMMSS, @RequestParam String body, @RequestParam String autor) {
        Optional<Article> article = articleRepository.findById(id);
        Article article1 = article.isPresent() ? article.get() : new Article();
        article1.setAutor(autor);
        article1.setBody(body);
        article1.setDateOfCreation(dateOfCreationYYMMDDHHMMSS);
        article1.setDateOfEdit(dateOfEditYYMMDDHHMMSS);
        article1.setHeader(header);
        articleRepository.save(article1);
    }

    @DeleteMapping("{id}")
    private void deleteArticle(@PathVariable Integer id) {
        articleRepository.deleteById(id);
    }
}


