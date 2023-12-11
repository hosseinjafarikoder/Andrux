package com.andrux.andrux.dto;

import com.andrux.andrux.entity.Blog;

import java.util.List;

public class BlogCategoryDto {
    private Long blogCategoryId;
    private String blogCategoryName;
    private Boolean status;
    private Blog parentCategory;
    private List<BlogCategoryDto> childCategoryList;

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

    public Blog getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Blog parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<BlogCategoryDto> getChildCategoryList() {
        return childCategoryList;
    }

    public void setChildCategoryList(List<BlogCategoryDto> childCategoryList) {
        this.childCategoryList = childCategoryList;
    }
}
