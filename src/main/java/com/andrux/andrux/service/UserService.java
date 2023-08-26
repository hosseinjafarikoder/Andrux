
package com.andrux.andrux.service;


import com.andrux.andrux.entity.User;

public interface UserService {
    void save(User user);

    void update(User user);

    User findByUsername(String username);

    void checkSecurity(String currentUser, String username);
}
