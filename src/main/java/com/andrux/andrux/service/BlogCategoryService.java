package com.andrux.andrux.service;


import com.andrux.andrux.dto.BlogCategoryDto;
import com.andrux.andrux.entity.BlogCategory;

import java.util.List;

public interface BlogCategoryService {
    BlogCategory saveOrUpdate(BlogCategory blogCategory) ;

    void deleteById(Long id);

    BlogCategory findById(Long id);

    List<BlogCategory> findAll();

    List<BlogCategoryDto> findAllByParentCategoryIsNull();

    List<BlogCategory> findAllByParentCategoryIsNotNull();

    List<BlogCategory> findAllByParentCategoryBlogCategoryIdIs(Long parentBlogCategoryId);

}
