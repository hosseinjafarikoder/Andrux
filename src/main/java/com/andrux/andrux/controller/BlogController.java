package com.andrux.andrux.controller;


import com.andrux.andrux.entity.Blog;
import com.andrux.andrux.entity.BlogCategory;
import com.andrux.andrux.entity.BlogTag;
import com.andrux.andrux.service.BlogCategoryService;
import com.andrux.andrux.service.BlogService;
import com.andrux.andrux.service.BlogTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogTagService blogTagService;
    @Autowired
    private BlogCategoryService blogCategoryService;

    //Blog
    @GetMapping("/blog/list")
    public String listBlog(Model theModel) {
        List<Blog> blogList = blogService.findAll();
        theModel.addAttribute("blogList", blogList);
        return "adminPanel/blog/th_blogList";
    }

    @GetMapping("/blog/showForm")
    public String showFormForAddBlog(Model theModel) {
        Blog blog = new Blog();
        theModel.addAttribute("blog", blog);
        List<BlogTag> blogTagList = blogTagService.findAll();
        theModel.addAttribute("blogTagList", blogTagList);
        List<BlogCategory> blogCategoryLis = blogCategoryService.findAll();
        theModel.addAttribute("blogCategoryLis", blogCategoryLis);
        return "adminPanel/blog/th_blog-form";
    }

    @PostMapping("/blog/saveBlog")
    public String saveBlog(@ModelAttribute("blog") Blog blog, @RequestParam("file") MultipartFile file) {
        blogService.saveOrUpdate(blog);
        String blogUrl = blogService.saveBlogImage(file, blog.getBlogId());
        blog.setUrl("images/myBannerFolder/"+blogUrl);
        //todo i use saveOrUpdate again because i need update url . (the first way got circular bean exception) i must check it later:
        blogService.saveOrUpdate(blog);
        return "redirect:/blog/blog/list";
    }

    @GetMapping("/blog/updateForm")
    public String showFormForUpdateBlog(@RequestParam("blogId") Long blogId, Model theModel) {
        Blog blog = blogService.findById(blogId);
        theModel.addAttribute("blog", blog);
        return "adminPanel/blog/th_blog-form";
    }

    @GetMapping("/blog/delete")
    public String deleteBlog(@RequestParam(value ="blogId") Long blogId) {
        blogService.deleteById(blogId);
        return "redirect:/blog/blog/list";
    }

}
