package com.andrux.andrux.service.impl;

import com.andrux.andrux.entity.CourseComment;
import com.andrux.andrux.repository.CourseCommentRepository;
import com.andrux.andrux.service.CourseCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseCommentServiceImpl implements CourseCommentService {

    @Autowired
    private CourseCommentRepository courseCommentRepository;

    @Override
    public CourseComment saveOrUpdate(CourseComment courseComment) {
        return courseCommentRepository.save(courseComment);
    }

    @Override
    public void deleteById(Long id) {
        courseCommentRepository.deleteById(id);
    }

    @Override
    public CourseComment findById(Long id) {
        return courseCommentRepository.findById(id).get();
    }

    @Override
    public List<CourseComment> findAll() {
        return courseCommentRepository.findAll();
    }

    @Override
    public List<CourseComment> findByCourseId(Long courseId) {
        return courseCommentRepository.findCourseCommentsByCourse_CourseId(courseId);
    }
}
