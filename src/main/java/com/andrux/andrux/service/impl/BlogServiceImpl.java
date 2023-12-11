package com.andrux.andrux.service.impl;


import com.andrux.andrux.entity.Blog;
import com.andrux.andrux.entity.BlogCategory;
import com.andrux.andrux.entity.BlogTag;
import com.andrux.andrux.exceptions.GeneralException;
import com.andrux.andrux.fileuploadService.service.FilesStorageService;
import com.andrux.andrux.repository.BlogRepository;
import com.andrux.andrux.service.BlogCategoryService;
import com.andrux.andrux.service.BlogService;
import com.andrux.andrux.service.BlogTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogTagService blogTagService;
    @Autowired
    private BlogCategoryService blogCategoryService;
    @Autowired
    FilesStorageService storageService;

    @Override
    public Blog saveOrUpdate(Blog blog) {
        //for productTag update :
        if (blog.getBlogTitle()!=null){
            List<BlogTag> blogTagList = new ArrayList<>();
            for (BlogTag elm : blog.getBlogTag()){
                BlogTag blogTag = blogTagService.findById(elm.getBlogTagId());
                if (blogTag != null){
                    blogTagList.add(blogTag);
                    blogTagService.saveOrUpdate(blogTag);
                }else {
                    throw new GeneralException("blog with id : "+blog.getBlogId()+" is not exist");
                }
            }
            blog.setBlogTag(blogTagList);
        }
        //for productCategory update:
        if (blog.getBlogCategory()!=null){
            List<BlogCategory> blogCategoryList = new ArrayList<>();
            for (BlogCategory elm : blog.getBlogCategory()){
                BlogCategory blogCategory = blogCategoryService.findById(elm.getBlogCategoryId());
                if (blogCategory != null){
                    blogCategoryList.add(blogCategory);
                    blogCategoryService.saveOrUpdate(blogCategory);
                }else {
                    throw new GeneralException("blog with id : "+blog.getBlogId()+" is not exist");
                }
            }
            blog.setBlogCategory(blogCategoryList);
        }

        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByStatusIs(Boolean status) {
        return blogRepository.findByStatusIs(status);
    }

    @Override
    public List<Blog> findByHaveDiscount(List<Blog> blog) {
//        List<Blog> productsWithDiscount = blog.stream().filter(x -> x.getDiscount() > 0).collect(Collectors.toList());
//        return productsWithDiscount;
        //todo
        return null;
    }

    @Override
    public String saveBlogImage(MultipartFile file, Long blogId) {
        String message = "";

        String blogUrl = null;
        try {
            blogUrl = storageService.save(file, blogId, "blog");
            message = "Uploaded the blog image successfully: " + file.getOriginalFilename();
            System.err.println(message);
            //todo
//            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "Could not upload the blog image: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            System.err.println(message);
            //todo
//            model.addAttribute("message", message);
        }
        return blogUrl;
    }
}
