package com.andrux.andrux.repository;


import com.andrux.andrux.entity.BlogComment;
import com.andrux.andrux.entity.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogCommentRepository extends JpaRepository<BlogComment,Long> {
        List<BlogComment> findBlogCommentsByBlog_BlogId (Long blogId);
}
