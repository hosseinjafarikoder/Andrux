package com.andrux.andrux.service.impl;


import com.andrux.andrux.entity.Course;
import com.andrux.andrux.entity.CourseCategory;
import com.andrux.andrux.entity.CourseTag;
import com.andrux.andrux.exceptions.GeneralException;
import com.andrux.andrux.repository.CourseRepository;
import com.andrux.andrux.service.CourseCategoryService;
import com.andrux.andrux.service.CourseService;
import com.andrux.andrux.service.CourseTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseTagService courseTagService;
    @Autowired
    private CourseCategoryService courseCategoryService;

    @Override
    public Course saveOrUpdate(Course course) {
        //for productTag update :
        if (course.getCourseTag()!=null){
            List<CourseTag> courseTagList = new ArrayList<>();
            for (CourseTag elm : course.getCourseTag()){
                CourseTag courseTag = courseTagService.findById(elm.getCourseTagId());
                if (courseTag != null){
                    courseTagList.add(courseTag);
                    courseTagService.saveOrUpdate(courseTag);
                }else {
                    throw new GeneralException("course with id : "+course.getCourseId()+" is not exist");
                }
            }
            course.setCourseTag(courseTagList);
        }
        //for productCategory update:
        if (course.getCourseCategory()!=null){
            List<CourseCategory> courseCategoryList = new ArrayList<>();
            for (CourseCategory elm : course.getCourseCategory()){
                CourseCategory courseCategory = courseCategoryService.findById(elm.getCourseCategoryId());
                if (courseCategory != null){
                    courseCategoryList.add(courseCategory);
                    courseCategoryService.saveOrUpdate(courseCategory);
                }else {
                    throw new GeneralException("course with id : "+course.getCourseId()+" is not exist");
                }
            }
            course.setCourseCategory(courseCategoryList);
        }

        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByStatusIs(Boolean status) {
        return courseRepository.findByStatusIs(status);
    }

    @Override
    public List<Course> findByHaveDiscount(List<Course> course) {
//        List<Course> productsWithDiscount = course.stream().filter(x -> x.getDiscount() > 0).collect(Collectors.toList());
//        return productsWithDiscount;
        //todo
        return null;
    }
}
