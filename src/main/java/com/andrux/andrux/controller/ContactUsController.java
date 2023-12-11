package com.andrux.andrux.controller;


import com.andrux.andrux.entity.AboutUs;
import com.andrux.andrux.service.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contact-us")
@RequiredArgsConstructor
public class ContactUsController {

    @Autowired
    private AboutUsService aboutUsService;

    @GetMapping("/")
    public String listBanner(Model theModel) {
        List<AboutUs> aboutUs = aboutUsService.findAll();
        theModel.addAttribute("aboutUs", aboutUs.get(0));
        return "contact-us/th_contact-us";
    }

}
