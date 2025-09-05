package com.auxirem.blogs.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String Title;

    

    @Column(columnDefinition = "Text",nullable = false)
   // private String slug; //SEO friendly URL
    private String Description;
    private String images;
    private String author;
    private String category;
    
    @ElementCollection
    private List<String> tags;

    @Column(nullable = false)
    private String status; // draft, published, archived

    private Integer readTime;
    private Integer viewsCount = 0;
   // private Boolean commentsEnabled = true;
    private String metaTitle;
    private String metaDescription;
    private LocalDateTime created_On;
    private LocalDateTime updated_On;  
   
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    /*public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }*/
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getReadTime() {
        return readTime;
    }
    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }
    public Integer getViewsCount() {
        return viewsCount;
    }
    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }
   /*public Boolean getCommentsEnabled() {
        return commentsEnabled;
    }
    public void setCommentsEnabled(Boolean commentsEnabled) {
        this.commentsEnabled = commentsEnabled;
    }*/
    public String getMetaTitle() {
        return metaTitle;
    }
    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }
    public String getMetaDescription() {
        return metaDescription;
    }
    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }
    public LocalDateTime getCreated_On() {
        return created_On;
    }
    public void setCreated_On(LocalDateTime created_On) {
        this.created_On = created_On;
    }
    public LocalDateTime getUpdated_On() {
        return updated_On;
    }
    public void setUpdated_On(LocalDateTime updated_On) {
        this.updated_On = updated_On;
    }
}
