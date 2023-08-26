package com.andrux.andrux.security.controller;

import com.andrux.andrux.entity.User;
import com.andrux.andrux.security.servivce.SecurityService;
import com.andrux.andrux.security.validator.UserValidator;
import com.andrux.andrux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        //TODO you must fix it abstract user
        model.addAttribute("userForm", new User());
//        BusinessOwner b = new BusinessOwner();
//        b.setUsername();

//        BusinessOwner businessUser = new BusinessOwner();

//        model.addAttribute("userForm", businessUser);

//        return "security/registration";
        return "security/register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "security/register";
        }
//        userForm.setCheckIsCustomer(true);
        userService.save(userForm);
//        Customer customer = new Customer();
//        customer.setCustomerUser(userForm);
//        customerService.saveOrUpdate(customer);

        //TODO this is the cause of error when i create a user
//        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null )
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

//        return "security/login";
        return "security/login";
    }

//    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Principal principal, Model model) {
        User currentUser = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser",currentUser);
        return "welcome";
    }

//    @RequestMapping(value = {"/testSecurity"}, method = RequestMethod.GET)
//    public String testSecurity() {
//        return "security/testSecurity";
//    }
}
