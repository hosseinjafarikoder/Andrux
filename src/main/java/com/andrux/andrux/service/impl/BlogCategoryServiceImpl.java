package com.andrux.andrux.service.impl;

import com.andrux.andrux.dto.BlogCategoryDto;
import com.andrux.andrux.entity.BlogCategory;
import com.andrux.andrux.mapper.BlogCategoryMapper;
import com.andrux.andrux.repository.BlogCategoryRepository;
import com.andrux.andrux.service.BlogCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogCategoryServiceImpl implements BlogCategoryService {

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;
    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Override
    public BlogCategory saveOrUpdate(BlogCategory blogCategory) {
        return blogCategoryRepository.save(blogCategory);
    }

    @Override
    public void deleteById(Long id) {
        blogCategoryRepository.deleteById(id);
    }

    @Override
    public BlogCategory findById(Long id) {
        return blogCategoryRepository.findById(id).get();
    }

    @Override
    public List<BlogCategory> findAll() {
        return blogCategoryRepository.findAll();
    }


    @Override
    public List<BlogCategoryDto> findAllByParentCategoryIsNull() {
//        return productCategoryRepository.findAllByParentCategoryIsNull();

        List<BlogCategory> parentCategoryList = blogCategoryRepository.findAllByParentCategoryIsNull();
        List<BlogCategoryDto> result = new ArrayList<>();
        for (BlogCategory elm : parentCategoryList){
            BlogCategoryDto productCategoryDto = blogCategoryMapper.convertTToDto(elm);
            List<BlogCategoryDto> childOfElm = blogCategoryMapper.convertListEntityToListDto(findAllByParentCategoryBlogCategoryIdIs(elm.getBlogCategoryId()));
            productCategoryDto.setChildCategoryList(childOfElm);
            result.add(productCategoryDto);
        }
        return result;
    }


    @Override
    public List<BlogCategory> findAllByParentCategoryIsNotNull() {
        return blogCategoryRepository.findAllByParentCategoryIsNotNull();
    }

    @Override
    public List<BlogCategory> findAllByParentCategoryBlogCategoryIdIs(Long parentBlogCategoryId) {
        return blogCategoryRepository.findAllByParentCategoryBlogCategoryIdIs(parentBlogCategoryId);
    }
}
