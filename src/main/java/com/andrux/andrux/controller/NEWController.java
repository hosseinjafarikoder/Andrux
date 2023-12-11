package com.andrux.andrux.controller;

import com.andrux.andrux.entity.CourseCategory;
import com.andrux.andrux.service.CourseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/new")
@RequiredArgsConstructor
public class NEWController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    //courseCategory
    @GetMapping("/courseCategory/list")
    public String listCourseCategories(Model theModel) {
        List<CourseCategory> courseCategoryList = courseCategoryService.findAll();
        theModel.addAttribute("courseCategories", courseCategoryList);
        return "course/courseCategories/th_courseCategoryList";
    }

    @GetMapping("/courseCategory/showForm")
    public String showFormForAddCourseCategory(Model theModel) {
        CourseCategory courseCategory = new CourseCategory();
        theModel.addAttribute("courseCategory", courseCategory);
        List<CourseCategory> courseCategoryList = courseCategoryService.findAll();
        theModel.addAttribute("courseCategoryList", courseCategoryList);
        return "course/courseCategories/th_courseCategory-form";
    }

    @PostMapping("/courseCategory/saveCourseCategory")
    public String saveCourseCategory(@ModelAttribute("courseCategory") CourseCategory courseCategory) {
        courseCategoryService.saveOrUpdate(courseCategory);
        return "redirect:/new/courseCategory/list";
    }

    @GetMapping("/courseCategory/updateForm")
    public String showFormForUpdateCourseCategory(@RequestParam("courseCategoryId") Long courseCategoryId, Model theModel) {
        CourseCategory courseCategory = courseCategoryService.findById(courseCategoryId);
        theModel.addAttribute("courseCategory", courseCategory);
        return "course/courseCategories/th_courseCategory-form";
    }

    @GetMapping("/courseCategory/delete")
    public String deleteCourseCategory(@RequestParam(value ="courseCategoryId") Long courseCategoryId) {
        courseCategoryService.deleteById(courseCategoryId);
        return "redirect:/new/courseCategory/list";
    }
}
