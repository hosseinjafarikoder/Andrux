package com.andrux.andrux.repository;


import com.andrux.andrux.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByStatusIs(Boolean status);
}
