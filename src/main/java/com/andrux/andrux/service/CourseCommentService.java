package com.andrux.andrux.service;



import com.andrux.andrux.entity.CourseComment;

import java.util.List;

public interface CourseCommentService {
    CourseComment saveOrUpdate(CourseComment courseComment) ;

    void deleteById(Long id);

    CourseComment findById(Long id);

    List<CourseComment> findAll();

    List<CourseComment> findByCourseId(Long courseId);
}
