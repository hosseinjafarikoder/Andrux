package com.andrux.andrux.controller;

import com.andrux.andrux.entity.User;
import com.andrux.andrux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;

    @GetMapping("/signup")
    public String index() {
//        return "signup/th_index";
        return "signup/th_login-register";
    }

    @PostMapping("/signup")
    public String signup(User user, @RequestParam("role") String roleName) {
        System.out.println(user);
        System.out.println(roleName);
        userService.register(user, roleName);
        return "redirect:/login";
    }
}
