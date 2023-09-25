package com.andrux.andrux.service;

import com.andrux.andrux.entity.User;

import java.util.List;

public interface UserService2 {
    User saveOrUpdate(User user) ;

    void deleteById(Long id);

    User findById(Long id);

    List<User> findAll();
}
