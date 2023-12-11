package com.andrux.andrux.controller;


import com.andrux.andrux.entity.BlogCategory;
import com.andrux.andrux.entity.BlogComment;
import com.andrux.andrux.service.BlogCategoryService;
import com.andrux.andrux.service.BlogCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogComment")
@RequiredArgsConstructor
public class BlogCommentController {

    @Autowired
    private BlogCommentService blogCommentService;

    //BlogComment
    @GetMapping("/blogComment/list")
    public String listBlogComment(Model theModel) {
        List<BlogComment> blogCommentList = blogCommentService.findAll();
        theModel.addAttribute("blogCommentList", blogCommentList);
        return "adminPanel/blogComment/th_blogCommentList";
    }

    @GetMapping("/blogComment/showForm")
    public String showFormForAddBlogComment(Model theModel) {
        BlogComment blogComment = new BlogComment();
        theModel.addAttribute("blogComment", blogComment);
        return "adminPanel/blogComment/th_blogComment-form";
    }

    @PostMapping("/blogComment/saveBlogComment")
    public String saveBlogComment(@ModelAttribute("blogComment") BlogComment blogComment) {
        blogCommentService.saveOrUpdate(blogComment);
        return "redirect:/blogComment/blogComment/list";
    }

    @GetMapping("/blogComment/updateForm")
    public String showFormForUpdateBlogComment(@RequestParam("blogCommentId") Long blogCommentId, Model theModel) {
        BlogComment blogComment = blogCommentService.findById(blogCommentId);
        theModel.addAttribute("blogComment", blogComment);
        return "adminPanel/blogComment/th_blogComment-form";
    }

    @GetMapping("/blogComment/delete")
    public String deleteBlogComment(@RequestParam(value ="blogCommentId") Long blogCommentId) {
        blogCommentService.deleteById(blogCommentId);
        return "redirect:/blogComment/blogComment/list";
    }

}
