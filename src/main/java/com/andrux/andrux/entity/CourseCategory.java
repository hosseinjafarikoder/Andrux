package com.andrux.andrux.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseCategoryId;
    private String courseCategoryName;
    private Boolean status;
    @ManyToMany(mappedBy = "courseCategory")
    private List<Course> courseList;

    @ManyToOne
    private CourseCategory parentCategory;

    public Long getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Long courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CourseCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CourseCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "{CategoryName='" + courseCategoryName + '\'' +'}';
    }
}
