package com.andrux.andrux.entity;


import net.bytebuddy.description.field.FieldDescription;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    private String author;
    private String blogTitle;
    private String description;
    private Boolean status;
    private String blogImage;
    private Date creationDate = new Date();
    private Date lastModified = new Date();
    private String url;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Blog_BlogTag",
            joinColumns = { @JoinColumn(name = "blog_id") },
            inverseJoinColumns = { @JoinColumn(name = "blogTag_id") }
    )
    private List<BlogTag> blogTag = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Blog_BlogCategory",
            joinColumns = { @JoinColumn(name = "blog_id") },
            inverseJoinColumns = { @JoinColumn(name = "blogCategory_id") }
    )
    private List<BlogCategory> blogCategory = new ArrayList<>();

    @OneToMany(mappedBy="blog")
    private List<BlogComment> blogComment = new ArrayList<>();
    private Integer view;
    private Integer like;
    private String reference;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BlogTag> getBlogTag() {
        return blogTag;
    }

    public void setBlogTag(List<BlogTag> blogTag) {
        this.blogTag = blogTag;
    }

    public List<BlogCategory> getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(List<BlogCategory> blogCategory) {
        this.blogCategory = blogCategory;
    }

    public List<BlogComment> getBlogComment() {
        return blogComment;
    }

    public void setBlogComment(List<BlogComment> blogComment) {
        this.blogComment = blogComment;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
