package com.abramova.blog_cms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "img")
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_img")
    private Integer idImg;
    @Column(name = "img_file_name", nullable = false)
    private String imgFileName;
    @Column(name = "directory_name")
    private String nameOfDirectory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "id_article"), name = "id", referencedColumnName = "id_article", nullable = false)
    @JsonBackReference
    private Article article;

    public Img() {
    }

    public Integer getIdImg() {
        return idImg;
    }

    public void setIdImg(Integer idImg) {
        this.idImg = idImg;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getNameOfDirectory() {
        return nameOfDirectory;
    }

    public void setNameOfDirectory(String nameOfDirectory) {
        this.nameOfDirectory = nameOfDirectory;
    }
}
