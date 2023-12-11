package com.andrux.andrux.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class BlogCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogCategoryId;
    private String blogCategoryName;
    private Boolean status;
    @ManyToMany(mappedBy = "blogCategory")
    private List<Blog> blogList;

    @ManyToOne
    private BlogCategory parentCategory;

    public Long getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Long blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public BlogCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(BlogCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "{CategoryName='" + blogCategoryName + '\'' +'}';
    }
}
