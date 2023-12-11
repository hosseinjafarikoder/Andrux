package com.andrux.andrux.repository;


import com.andrux.andrux.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseCategoryRepository extends JpaRepository<CourseCategory,Long> {
    List<CourseCategory> findAllByParentCategoryIsNull ();
    List<CourseCategory> findAllByParentCategoryIsNotNull ();
    List<CourseCategory> findAllByParentCategoryCourseCategoryIdIs(Long parentCourseCategoryId);
}
