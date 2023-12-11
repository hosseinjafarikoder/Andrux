package com.andrux.andrux.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class BlogTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogTagId;
    private String blogTagName;
    private Boolean status;
    private Long parentTag;
    @ManyToMany(mappedBy = "blogTag")
    private List<Blog> blogList;

    public Long getBlogTagId() {
        return blogTagId;
    }

    public void setBlogTagId(Long blogTagId) {
        this.blogTagId = blogTagId;
    }

    public String getBlogTagName() {
        return blogTagName;
    }

    public void setBlogTagName(String blogTagName) {
        this.blogTagName = blogTagName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getParentTag() {
        return parentTag;
    }

    public void setParentTag(Long parentTag) {
        this.parentTag = parentTag;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    @Override
    public String toString() {
        return "{TagName='" + blogTagName + '\'' +'}';
    }
}
