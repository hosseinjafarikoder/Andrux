package com.andrux.andrux.repository;


import com.andrux.andrux.entity.BlogCategory;
import com.andrux.andrux.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogCategoryRepository extends JpaRepository<BlogCategory,Long> {
    List<BlogCategory> findAllByParentCategoryIsNull ();
    List<BlogCategory> findAllByParentCategoryIsNotNull ();
    List<BlogCategory> findAllByParentCategoryBlogCategoryIdIs(Long parentBlogCategoryId);
}
