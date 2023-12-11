package com.andrux.andrux.dto;


import com.andrux.andrux.entity.CourseCategory;

import java.util.List;

public class CourseCategoryDto {
    private Long courseCategoryId;
    private String courseCategoryName;
    private Boolean status;
//    private List<Product> productList;
    private CourseCategory parentCategory;

    private List<CourseCategoryDto> childCategoryList;

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

    public List<CourseCategoryDto> getChildCategoryList() {
        return childCategoryList;
    }

    public void setChildCategoryList(List<CourseCategoryDto> childCategoryList) {
        this.childCategoryList = childCategoryList;
    }
}
