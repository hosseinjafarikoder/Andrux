package com.andrux.andrux.entity;

import javax.persistence.*;

@Entity
public class CourseComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseCommentId;
    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private User user;
    private String content;
    private String creationDate;
    private Long replyOn;
    private Integer like;
    private Integer disLike;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "course_entity_id")
    private Course course;


    public Long getCourseCommentId() {
        return courseCommentId;
    }

    public void setCourseCommentId(Long courseCommentId) {
        this.courseCommentId = courseCommentId;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
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
}
