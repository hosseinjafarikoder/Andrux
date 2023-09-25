package com.andrux.andrux.service;

import com.andrux.andrux.entity.Permission;

import java.util.List;

public interface PermissionService {

    Permission saveOrUpdate(Permission permission) ;

    void deleteById(Long id);

    Permission findById(Long id);

    List<Permission> findAll();
}
