package com.andrux.andrux.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogCommentId;
    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private User user;
    private String content;
    private Date creationDate = new Date();
    private Long replyOn;
    private Integer like;
    private Integer disLike;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "blog_entity_id")
    private Blog blog;

    public Long getBlogCommentId() {
        return blogCommentId;
    }

    public void setBlogCommentId(Long blogCommentId) {
        this.blogCommentId = blogCommentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getReplyOn() {
        return replyOn;
    }

    public void setReplyOn(Long replyOn) {
        this.replyOn = replyOn;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDisLike() {
        return disLike;
    }

    public void setDisLike(Integer disLike) {
        this.disLike = disLike;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
