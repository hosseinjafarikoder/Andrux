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

//    @Override
//    public void checkUniqueDuty(User user, String duty) {
//        if (Objects.equals(duty, "customer") && user.getCustomer()!=null){
//            throw new NotUniqueDutyException("شما دوبار به عنوان مشتری نمی توانید ثبت نام کنید");
//        }else if (Objects.equals(duty, "businessOwner") && user.getBusinessOwner()!=null){
//            throw new NotUniqueDutyException("شما دوبار به عنوان صاحب کسب و کار نمی توانید ثبت نام کنید");
//        }else if (Objects.equals(duty, "manager") && user.getManager()!=null){
//            throw new NotUniqueDutyException("شما دوبار به عنوان  کارمند نمی توانید ثبت نام کنید");
//        }
//    }

//    @Override
//    public void updateDuty(User currentUser,String duty, boolean status) {
//        if (Objects.equals(duty, "customer")){
//            currentUser.setCheckIsCustomer(status);
//        }else if (Objects.equals(duty, "businessOwner")){
//            currentUser.setCheckIsBusinessOwner(status);
//        }else if (Objects.equals(duty, "manager")){
//            currentUser.setCheckIsManager(status);
//        }else {
//            throw new RuntimeException("unknown keyword for duty");
//        }
//        userRepository.save(currentUser);
//    }

    //todo i must check it later
    @Override
    public void checkSecurity(String currentUser, String username) {
        if (!Objects.equals(currentUser, username)){
            throw new SecurityUserException("مشکوک به اطلاعات کاربر ");
        }
    }
}
