package com.andrux.andrux.controller;

import com.andrux.andrux.dto.CourseCategoryDto;
import com.andrux.andrux.entity.Banner;
import com.andrux.andrux.entity.Permission;
import com.andrux.andrux.entity.Role;
import com.andrux.andrux.service.BannerService;
import com.andrux.andrux.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;


@Controller
public class ApplicationController {
    @PersistenceContext
    EntityManager em;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private CourseCategoryService courseCategoryService;
    @Autowired
    private BannerService bannerService;

    @GetMapping("/")
    public String index(Model theModel) {
        System.out.println("index is ok...");
//        return "th_old-index";

        //parent
//        List<ProductCategory> allParentProductCategory = productCategoryService.findAllByParentCategoryIsNull();
        List<CourseCategoryDto> allParentCourseCategory = courseCategoryService.findAllByParentCategoryIsNull();

        theModel.addAttribute("allParentCourseCategory", allParentCourseCategory);

        List<Banner> bannerList = bannerService.findAll();
        theModel.addAttribute("bannerList",bannerList);
        System.out.println("#########################"+bannerList.get(0).getUrl());
        return "th_index";
    }

    /**
     * Add Data of Permission, Role, and User
     */
    @Transactional
    @GetMapping("/settings")
    public String settings() {
        Permission readIssue = new Permission("readIssue");
        Permission writeIssue = new Permission("writeIssue");
        Permission manageUser = new Permission("manageUser");

        em.persist(readIssue);
        em.persist(writeIssue);
        em.persist(manageUser);

        Role adminRole = new Role("admin");
        HashSet<Permission> adminPermissions = new HashSet<>();
        adminPermissions.add(readIssue);
        adminPermissions.add(writeIssue);
        adminPermissions.add(manageUser);
        adminRole.setPermissions(adminPermissions);
        em.persist(adminRole);

        Role developerRole = new Role("developer");

        HashSet<Permission> developerPermissions = new HashSet<>();
        developerPermissions.add(readIssue);
        developerPermissions.add(writeIssue);
        developerRole.setPermissions(developerPermissions);
        em.persist(developerRole);

        Role guestRole = new Role("guest");
        HashSet<Permission> guestPermissions = new HashSet<>();
        guestPermissions.add(readIssue);
        guestRole.setPermissions(guestPermissions);
        em.persist(guestRole);
        return "th_old-index";
    }

}
