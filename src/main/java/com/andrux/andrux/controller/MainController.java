package com.andrux.andrux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/welcome2")
    public String welcome(){
        logger.info("welcome is ok");
        return "welcome2";
    }

    @GetMapping("/index")
    public String index(){
        logger.info("index is ok");
        return "index";
    }
}
