package com.andrux.andrux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/index")
    public String index(){
        logger.info("index is correct");
        return "index";
    }
}
