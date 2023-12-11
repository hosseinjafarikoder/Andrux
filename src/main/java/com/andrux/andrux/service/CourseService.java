package com.andrux.andrux.service;



import com.andrux.andrux.entity.Course;

import java.util.List;

public interface CourseService {
    Course saveOrUpdate(Course course) ;

    void deleteById(Long id);

    Course findById(Long id);

    List<Course> findAll();

    List<Course> findByStatusIs (Boolean status);

    List<Course> findByHaveDiscount (List<Course> courses);
}
