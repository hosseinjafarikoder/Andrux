package com.andrux.andrux.service;



import com.andrux.andrux.entity.CourseTag;

import java.util.List;

public interface CourseTagService {
    CourseTag saveOrUpdate(CourseTag courseTag) ;

    void deleteById(Long id);

    CourseTag findById(Long id);

    List<CourseTag> findAll();
}
