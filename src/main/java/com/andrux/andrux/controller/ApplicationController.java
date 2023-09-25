package com.andrux.andrux.controller;

import com.andrux.andrux.entity.Permission;
import com.andrux.andrux.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;


@Controller
public class ApplicationController {
    @PersistenceContext
    EntityManager em;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index() {
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
        return "th_index";
    }

}
