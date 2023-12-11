package com.andrux.andrux.service;



import com.andrux.andrux.dto.CourseCategoryDto;
import com.andrux.andrux.entity.CourseCategory;

import java.util.List;

public interface CourseCategoryService {
    CourseCategory saveOrUpdate(CourseCategory courseCategory) ;

    void deleteById(Long id);

    CourseCategory findById(Long id);

    List<CourseCategory> findAll();

//    List<ProductCategory> findAllByParentCategoryIsNull();
    List<CourseCategoryDto> findAllByParentCategoryIsNull();

    List<CourseCategory> findAllByParentCategoryIsNotNull();

    List<CourseCategory> findAllByParentCategoryCourseCategoryIdIs(Long parentCourseCategoryId);

}
