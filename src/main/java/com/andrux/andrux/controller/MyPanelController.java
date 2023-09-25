package com.andrux.andrux.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPanel")
@RequiredArgsConstructor
public class MyPanelController {

    @GetMapping
    public String adminIndex() {
        return "myPanel/th_index";
    }
}
