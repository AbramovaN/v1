package com.abramova.blog_cms.controller;

import com.abramova.blog_cms.entity.Img;
import com.abramova.blog_cms.repository.ArticleRepository;
import com.abramova.blog_cms.repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("v3")
public class ImgController {
    @Autowired
    private ImgRepository imgRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    private Iterable<Img> getAll() {
        return imgRepository.findAll();
    }

    @GetMapping("{id}")
    private Iterable<Img> getAllByArticleId(@PathVariable Integer id) {
        return imgRepository.findAllByArticle(articleRepository.findById(id).orElse(null));
    }

    @PostMapping
    private void add(@RequestParam MultipartFile file, @RequestParam String nameOfDirectory, @RequestParam Integer idOfArticle) {
        try {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            Path path = Paths.get("src/main/resources/img/" + nameOfDirectory);
            if (!Files.exists(path)) {
                new File("src/main/resources/img/" + nameOfDirectory).mkdir();
            }
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + "/" + filename)));
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Img img = new Img();
        img.setArticle(articleRepository.findById(idOfArticle).orElse(null));
        img.setImgFileName(file.getOriginalFilename());
        img.setNameOfDirectory(nameOfDirectory);
        imgRepository.save(img);
    }

    @DeleteMapping("{id}")
    private void deleteImg(@PathVariable Integer id) {
        Img img = imgRepository.findById(id).orElse(null);
        File file = new File("src/main/resources/img/" + img.getNameOfDirectory() + "/" + img.getImgFileName());
        if (file.exists()) {
            file.delete();
        }
        imgRepository.deleteById(id);
    }

}
