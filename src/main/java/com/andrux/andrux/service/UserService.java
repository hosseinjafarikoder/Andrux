package com.andrux.andrux.service;


import com.andrux.andrux.entity.User;

import java.util.List;


public interface UserService {

    public void register(User user, String roleName);

    public List<User> findAll();

}
