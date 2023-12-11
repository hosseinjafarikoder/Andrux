package com.andrux.andrux.service;


import com.andrux.andrux.entity.BlogTag;

import java.util.List;

public interface BlogTagService {
    BlogTag saveOrUpdate(BlogTag blogTag) ;

    void deleteById(Long id);

    BlogTag findById(Long id);

    List<BlogTag> findAll();
}
