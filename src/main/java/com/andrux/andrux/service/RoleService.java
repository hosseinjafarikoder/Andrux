package com.andrux.andrux.service;


import com.andrux.andrux.entity.Role;

import java.util.List;

public interface RoleService {
    Role saveOrUpdate(Role role) ;

    void deleteById(Long id);

    Role findById(Long id);

    List<Role> findAll();
}
