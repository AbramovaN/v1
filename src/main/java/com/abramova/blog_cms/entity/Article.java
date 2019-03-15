package com.abramova.blog_cms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private Integer idArticle;
    @Column(nullable = false, length = 400)
    private String header;
    @Column(name = "date_of_creation", nullable = false)
    private Timestamp dateOfCreation;
    @Column(name = "date_of_edit", nullable = false)
    private Timestamp dateOfEdit;
    @Column(nullable = false, length = 1000)
    private String body;
    @Column(nullable = false, length = 255)
    private String autor;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Img.class, mappedBy = "article", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Img> imgs;

    public Article() {
    }

    public Article(String header, Timestamp dateOfCreation, Timestamp dateOfEdit, String body, String autor) {
        this.header = header;
        this.dateOfCreation = dateOfCreation;
        this.dateOfEdit = dateOfEdit;
        this.body = body;
        this.autor = autor;
        imgs = new ArrayList<>();
    }

    public Integer getId() {
        return idArticle;
    }

    public void setId(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Timestamp getDateOfEdit() {
        return dateOfEdit;
    }

    public void setDateOfEdit(Timestamp dateOfEdit) {
        this.dateOfEdit = dateOfEdit;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Img> getImgs() {
        return imgs;
    }

    public void setImgs(List<Img> imgs) {
        this.imgs = imgs;
    }

    public void addImg(Img img) {
        img.setArticle(this);
        imgs.add(img);
    }

    public void removeImg(Img img) {
        imgs.remove(img);
    }
}
