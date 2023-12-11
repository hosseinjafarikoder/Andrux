package com.andrux.andrux.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // get error status
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // TODO: log error details here

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            // display specific error page
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/th_error404";
            }
//            else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "500";
//            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
//                return "403";
//            }
        }

        // display generic error
        System.out.println(Integer.parseInt(status.toString()));
        System.err.println("error method return null line");
//        return "error";
        return null;
    }
}