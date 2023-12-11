package com.andrux.andrux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
//    public String index(Model model) {
    public String index() {

//        model.addAttribute("test","isisisi");

//        List<String> myList = Arrays.asList("one","two","three");
//        model.addAttribute("list",myList);
//        return "login/th_index";
        return "signup/th_login-register";
    }

}
