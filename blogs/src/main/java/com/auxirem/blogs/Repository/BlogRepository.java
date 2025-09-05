package com.auxirem.blogs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auxirem.blogs.Model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    
}
    