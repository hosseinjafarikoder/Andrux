package com.andrux.andrux.controller;


import com.andrux.andrux.entity.Permission;
import com.andrux.andrux.entity.Role;
import com.andrux.andrux.entity.User;
import com.andrux.andrux.service.PermissionService;
import com.andrux.andrux.service.RoleService;
import com.andrux.andrux.service.UserService;
import com.andrux.andrux.service.UserService2;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserService2 userService2;

    @Autowired
    private final RoleService roleService;

    @Autowired
    private final PermissionService permissionService;

    @Autowired
    private final PasswordEncoder passwordEncoder;



    @GetMapping
    public String adminIndex() {
        return "userAdmin/th_index";
    }

    //roles endpoints :

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userService2.findAll();
        model.addAttribute("users", users);
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "userAdmin/th_users";
    }

    @PostMapping("/users/add")
    public String addUsers(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService2.saveOrUpdate(user);
        return "redirect:/admin/users";
    }

    //todo must fix access deny error and use DeleteMapping instead of GetMapping :
    @GetMapping("/users/delete/{userId}")
    public String deleteUsers(@PathVariable("userId") Long userId) {
        userService2.deleteById(userId);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/update/{userId}")
    public String updateUsers(@PathVariable("userId") Long userId, Model theModel) {
        User user = userService2.findById(userId);
        theModel.addAttribute("user", user);
        List<Role> roles = roleService.findAll();
        theModel.addAttribute("roles", roles);
        return "userAdmin/th_update_user";
    }

    @PostMapping("/users/saveUpdate")
    public String saveUpdateUsers(User user) {
        userService2.saveOrUpdate(user);
        return "redirect:/admin/users";
    }


    //permissions endpoints :

    @GetMapping("/permissions")
    public String permissions(Model model) {
        List<Permission> permissions = permissionService.findAll();
        model.addAttribute("permissions", permissions);
        return "userAdmin/th_permissions";
    }

    @PostMapping("/permissions/add")
    public String addPermissions(Permission permission) {
        permissionService.saveOrUpdate(permission);
        return "redirect:/admin/permissions";
    }

    //todo must fix access deny error and use DeleteMapping instead of GetMapping :
    @GetMapping("/permissions/delete/{permissionId}")
    public String deletePermissions(@PathVariable("permissionId") Long permissionId) {
        permissionService.deleteById(permissionId);
        return "redirect:/admin/permissions";
    }

    @GetMapping("/permissions/update/{permissionId}")
    public String updatePermissions(@PathVariable("permissionId") Long permissionId, Model theModel) {
        Permission permission = permissionService.findById(permissionId);
        theModel.addAttribute("permission", permission);
        return "userAdmin/th_update_permission";
    }

    @PostMapping("/permissions/saveUpdate")
    public String saveUpdatePermissions(Permission permission) {
        permissionService.saveOrUpdate(permission);
        return "redirect:/admin/permissions";
    }

    //roles endpoints :
    @GetMapping("/roles")
    public String roles(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        List<Permission> permissions = permissionService.findAll();
        model.addAttribute("permissions", permissions);
        return "userAdmin/th_roles";
    }

    @PostMapping("/roles/add")
    public String addRoles(Role role) {
        roleService.saveOrUpdate(role);
        return "redirect:/admin/roles";
    }

    //todo must fix access deny error and use DeleteMapping instead of GetMapping :
    @GetMapping("/roles/delete/{roleId}")
    public String deleteRole(@PathVariable("roleId") Long roleId) {
        roleService.deleteById(roleId);
        return "redirect:/admin/roles";
    }

    @GetMapping("/roles/update/{roleId}")
    public String updateRoles(@PathVariable("roleId") Long roleId, Model theModel) {
        Role role = roleService.findById(roleId);
        theModel.addAttribute("role", role);
        List<Permission> permissions = permissionService.findAll();
        theModel.addAttribute("permissions", permissions);
        return "userAdmin/th_update_role";
    }

    @PostMapping("/roles/saveUpdate")
    public String saveUpdateRoles(Role role) {
        roleService.saveOrUpdate(role);
        return "redirect:/admin/roles";
    }
}
