package com.andrux.andrux.repository;


import com.andrux.andrux.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByStatusIs (Boolean status);
}
