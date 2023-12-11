package com.andrux.andrux.controller;


import com.andrux.andrux.entity.BlogCategory;
import com.andrux.andrux.service.BlogCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogCategory")
@RequiredArgsConstructor
public class BlogCategoryController {

    @Autowired
    private BlogCategoryService blogCategoryService;

    //BlogCategory
    @GetMapping("/blogCategory/list")
    public String listBlogCategory(Model theModel) {
        List<BlogCategory> blogCategoryList = blogCategoryService.findAll();
        theModel.addAttribute("blogCategoryList", blogCategoryList);
        return "adminPanel/blogCategory/th_blogCategoryList";
    }

    @GetMapping("/blogCategory/showForm")
    public String showFormForAddBlogCategory(Model theModel) {
        BlogCategory blogCategory = new BlogCategory();
        theModel.addAttribute("blogCategory", blogCategory);
        return "adminPanel/blogCategory/th_blogCategory-form";
    }

    @PostMapping("/blogCategory/saveBlogCategory")
    public String saveBlogCategory(@ModelAttribute("blogCategory") BlogCategory blogCategory) {
        blogCategoryService.saveOrUpdate(blogCategory);
        return "redirect:/blogCategory/blogCategory/list";
    }

    @GetMapping("/blogCategory/updateForm")
    public String showFormForUpdateBlogCategory(@RequestParam("blogCategoryId") Long blogCategoryId, Model theModel) {
        BlogCategory blogCategory = blogCategoryService.findById(blogCategoryId);
        theModel.addAttribute("blogCategory", blogCategory);
        return "adminPanel/blogCategory/th_blogCategory-form";
    }

    @GetMapping("/blogCategory/delete")
    public String deleteBlogCategory(@RequestParam(value ="blogCategoryId") Long blogCategoryId) {
        blogCategoryService.deleteById(blogCategoryId);
        return "redirect:/blogCategory/blogCategory/list";
    }

}
