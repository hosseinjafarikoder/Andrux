package com.andrux.andrux.service;


import com.andrux.andrux.entity.Blog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BlogService {
    Blog saveOrUpdate(Blog blog) ;

    void deleteById(Long id);

    Blog findById(Long id);

    List<Blog> findAll();

    List<Blog> findByStatusIs (Boolean status);

    List<Blog> findByHaveDiscount (List<Blog> blogs);

    String saveBlogImage(MultipartFile file, Long blogId);

}
