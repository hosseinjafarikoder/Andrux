package com.andrux.andrux.repository;


import com.andrux.andrux.entity.User;

import java.util.List;


public interface UserRepository {

    public void register(User user, String roleName);

    public List<User> findAll();

}
