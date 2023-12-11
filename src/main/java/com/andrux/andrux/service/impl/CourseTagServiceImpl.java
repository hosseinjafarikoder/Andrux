package com.andrux.andrux.service.impl;


import com.andrux.andrux.entity.CourseTag;
import com.andrux.andrux.repository.CourseTagRepository;
import com.andrux.andrux.service.CourseTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseTagServiceImpl implements CourseTagService {

    @Autowired
    private CourseTagRepository courseTagRepository;

    @Override
    public CourseTag saveOrUpdate(CourseTag courseTag) {
        return courseTagRepository.save(courseTag);
    }

    @Override
    public void deleteById(Long id) {
        courseTagRepository.deleteById(id);
    }

    @Override
    public CourseTag findById(Long id) {
        return courseTagRepository.findById(id).get();
    }

    @Override
    public List<CourseTag> findAll() {
        return courseTagRepository.findAll();
    }
}
