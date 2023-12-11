package com.andrux.andrux.controller;


import com.andrux.andrux.entity.AboutUs;
import com.andrux.andrux.entity.Banner;
import com.andrux.andrux.service.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/a-aboutUs")
@RequiredArgsConstructor
public class AboutUsController {

    @Autowired
    private AboutUsService aboutUsService;

    @GetMapping("/")
    public String listBanner(Model theModel) {
        List<AboutUs> aboutUs = aboutUsService.findAll();
        theModel.addAttribute("aboutUs", aboutUs.get(0));
        return "about-us/about-us";
    }

    @GetMapping("/check")
    public String listBannerManager(Model theModel) {
        List<AboutUs> aboutUs = aboutUsService.findAll();
        theModel.addAttribute("aboutUs", aboutUs);
        return "adminPanel/a-aboutUs/th_aboutUsList";
    }

    @GetMapping("/showForm")
    public String showFormForAddAboutUs(Model theModel) {
        AboutUs aboutUs = new AboutUs();
        theModel.addAttribute("aboutUs", aboutUs);
        return "adminPanel/a-aboutUs/th_aboutUs-form";
    }

    @PostMapping("/saveAboutUs")
    public String saveAboutUs(@ModelAttribute("id") AboutUs aboutUs) {
        aboutUsService.saveOrUpdate(aboutUs);
        return "redirect:/a-aboutUs/check";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdateAboutUs(@RequestParam("id") Long id, Model theModel) {
        AboutUs aboutUs = aboutUsService.findById(id);
        theModel.addAttribute("aboutUs", aboutUs);
        return "adminPanel/a-aboutUs/th_aboutUs-form";
    }

    @GetMapping("/delete")
    public String deleteAboutUs(@RequestParam(value ="Id") Long id) {
        aboutUsService.deleteById(id);
        return "redirect:/a-aboutUs/check";
    }

}
