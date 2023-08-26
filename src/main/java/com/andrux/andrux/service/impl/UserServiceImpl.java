package com.andrux.andrux.service.impl;

import com.andrux.andrux.entity.User;
import com.andrux.andrux.exceptions.SecurityUserException;
import com.andrux.andrux.repository.RoleRepository;
import com.andrux.andrux.repository.UserRepository;
import com.andrux.andrux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void checkSecurity(String currentUser, String username) {
        if (!Objects.equals(currentUser, username)){
            throw new SecurityUserException("مشکوک به اطلاعات کاربر ");
        }
    }
}
