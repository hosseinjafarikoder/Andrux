package com.andrux.andrux.service.impl;


import com.andrux.andrux.entity.BlogTag;
import com.andrux.andrux.entity.CourseTag;
import com.andrux.andrux.repository.BlogTagRepository;
import com.andrux.andrux.repository.CourseTagRepository;
import com.andrux.andrux.service.BlogTagService;
import com.andrux.andrux.service.CourseTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogTagServiceImpl implements BlogTagService {

    @Autowired
    private BlogTagRepository blogTagRepository;

    @Override
    public BlogTag saveOrUpdate(BlogTag blogTag) {
        return blogTagRepository.save(blogTag);
    }

    @Override
    public void deleteById(Long id) {
        blogTagRepository.deleteById(id);
    }

    @Override
    public BlogTag findById(Long id) {
        return blogTagRepository.findById(id).get();
    }

    @Override
    public List<BlogTag> findAll() {
        return blogTagRepository.findAll();
    }
}
