package com.andrux.andrux.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CourseTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseTagId;
    private String courseTagName;
    private Boolean status;
    private Long parentTag;
    @ManyToMany(mappedBy = "courseTag")
    private List<Course> courseList;


    public Long getCourseTagId() {
        return courseTagId;
    }

    public void setCourseTagId(Long courseTagId) {
        this.courseTagId = courseTagId;
    }

    public String getCourseTagName() {
        return courseTagName;
    }

    public void setCourseTagName(String courseTagName) {
        this.courseTagName = courseTagName;
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

    @Override
    public String toString() {
        return "{TagName='" + courseTagName + '\'' +'}';
    }
}
