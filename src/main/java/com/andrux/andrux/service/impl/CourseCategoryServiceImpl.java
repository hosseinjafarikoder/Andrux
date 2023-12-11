package com.andrux.andrux.service.impl;

import com.andrux.andrux.dto.CourseCategoryDto;
import com.andrux.andrux.entity.CourseCategory;
import com.andrux.andrux.mapper.CourseCategoryMapper;
import com.andrux.andrux.repository.CourseCategoryRepository;
import com.andrux.andrux.service.CourseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryRepository courseCategoryRepository;
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    @Override
    public CourseCategory saveOrUpdate(CourseCategory courseCategory) {
        return courseCategoryRepository.save(courseCategory);
    }

    @Override
    public void deleteById(Long id) {
        courseCategoryRepository.deleteById(id);
    }

    @Override
    public CourseCategory findById(Long id) {
        return courseCategoryRepository.findById(id).get();
    }

    @Override
    public List<CourseCategory> findAll() {
        return courseCategoryRepository.findAll();
    }

//    @Override
//    public List<ProductCategory> findAllByParentCategoryIsNull() {
//        return productCategoryRepository.findAllByParentCategoryIsNull();
//    }

    @Override
    public List<CourseCategoryDto> findAllByParentCategoryIsNull() {
//        return productCategoryRepository.findAllByParentCategoryIsNull();

        List<CourseCategory> parentCategoryList = courseCategoryRepository.findAllByParentCategoryIsNull();
        List<CourseCategoryDto> result = new ArrayList<>();
        for (CourseCategory elm : parentCategoryList){
            CourseCategoryDto productCategoryDto = courseCategoryMapper.convertTToDto(elm);
            List<CourseCategoryDto> childOfElm = courseCategoryMapper.convertListEntityToListDto(findAllByParentCategoryCourseCategoryIdIs(elm.getCourseCategoryId()));
            productCategoryDto.setChildCategoryList(childOfElm);
            result.add(productCategoryDto);
        }
        return result;
    }


    @Override
    public List<CourseCategory> findAllByParentCategoryIsNotNull() {
        return courseCategoryRepository.findAllByParentCategoryIsNotNull();
    }

    @Override
    public List<CourseCategory> findAllByParentCategoryCourseCategoryIdIs(Long parentCourseCategoryId) {
        return courseCategoryRepository.findAllByParentCategoryCourseCategoryIdIs(parentCourseCategoryId);
    }
}
