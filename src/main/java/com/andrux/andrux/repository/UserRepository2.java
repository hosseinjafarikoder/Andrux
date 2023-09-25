package com.andrux.andrux.repository;

import com.andrux.andrux.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository2 extends JpaRepository<User,Long> {
}
