package com.andrux.andrux.repository;


import com.andrux.andrux.entity.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseCommentRepository extends JpaRepository<CourseComment,Long> {
    List<CourseComment> findCourseCommentsByCourse_CourseId (Long courseId);
}
