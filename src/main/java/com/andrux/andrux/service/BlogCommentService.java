package com.andrux.andrux.service;


import com.andrux.andrux.entity.BlogComment;

import java.util.List;

public interface BlogCommentService {
    BlogComment saveOrUpdate(BlogComment blogComment) ;

    void deleteById(Long id);

    BlogComment findById(Long id);

    List<BlogComment> findAll();

    List<BlogComment> findByBlogId(Long blogId);
}
