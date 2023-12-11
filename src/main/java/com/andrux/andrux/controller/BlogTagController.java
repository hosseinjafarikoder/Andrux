package com.andrux.andrux.controller;


import com.andrux.andrux.entity.BlogTag;
import com.andrux.andrux.service.BlogTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogTag")
@RequiredArgsConstructor
public class BlogTagController {

    @Autowired
    private BlogTagService blogTagService;

    //BlogTag
    @GetMapping("/blogTag/list")
    public String listBlogTag(Model theModel) {
        List<BlogTag> blogTagList = blogTagService.findAll();
        theModel.addAttribute("blogTagList", blogTagList);
        return "adminPanel/blogTag/th_blogTagList";
    }

    @GetMapping("/blogTag/showForm")
    public String showFormForAddBlogTag(Model theModel) {
        BlogTag blogTag = new BlogTag();
        theModel.addAttribute("blogTag", blogTag);
        return "adminPanel/blogTag/th_blogTag-form";
    }

    @PostMapping("/blogTag/saveBlogTag")
    public String saveBlogTag(@ModelAttribute("blogTag") BlogTag blogTag) {
        blogTagService.saveOrUpdate(blogTag);
        return "redirect:/blogTag/blogTag/list";
    }

    @GetMapping("/blogTag/updateForm")
    public String showFormForUpdateBlogTag(@RequestParam("blogTagId") Long blogTagId, Model theModel) {
        BlogTag blogTag = blogTagService.findById(blogTagId);
        theModel.addAttribute("blogTag", blogTag);
        return "adminPanel/blogTag/th_blogTag-form";
    }

    @GetMapping("/blogTag/delete")
    public String deleteBlogTag(@RequestParam(value ="blogTagId") Long blogTagId) {
        blogTagService.deleteById(blogTagId);
        return "redirect:/blogTag/blogTag/list";
    }

}
