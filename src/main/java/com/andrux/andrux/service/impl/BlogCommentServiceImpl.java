package com.andrux.andrux.service.impl;

import com.andrux.andrux.entity.BlogComment;
import com.andrux.andrux.entity.CourseComment;
import com.andrux.andrux.repository.BlogCommentRepository;
import com.andrux.andrux.repository.CourseCommentRepository;
import com.andrux.andrux.service.BlogCommentService;
import com.andrux.andrux.service.CourseCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogCommentServiceImpl implements BlogCommentService {

    @Autowired
    private BlogCommentRepository blogCommentRepository;

    @Override
    public BlogComment saveOrUpdate(BlogComment blogComment) {
        return blogCommentRepository.save(blogComment);
    }

    @Override
    public void deleteById(Long id) {
        blogCommentRepository.deleteById(id);
    }

    @Override
    public BlogComment findById(Long id) {
        return blogCommentRepository.findById(id).get();
    }

    @Override
    public List<BlogComment> findAll() {
        return blogCommentRepository.findAll();
    }

    @Override
    public List<BlogComment> findByBlogId(Long blogId) {
        return blogCommentRepository.findBlogCommentsByBlog_BlogId(blogId);
    }
}
