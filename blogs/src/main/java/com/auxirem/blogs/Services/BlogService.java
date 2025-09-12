package com.auxirem.blogs.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxirem.blogs.Model.Blog;
import com.auxirem.blogs.Repository.BlogRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    // Get all blogs
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
    public Blog getBlogById(Long id) {
        Optional<Blog> existingBlog = blogRepository.findById(id);
        if (existingBlog.isPresent()) {
           return  existingBlog.get();
        }else{
           
            return null;
           
        }
    
    }

    public Blog createNewBlog(Blog blog){
        blog.setCreated_On(LocalDateTime.now());
        blog.setUpdated_On(LocalDateTime.now());
        return  blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
       return blogRepository.findById(id).map(blog -> {
            blog.setTitle(updatedBlog.getTitle());
            blog.setContent(updatedBlog.getContent());
            blog.setThumbnailImage(updatedBlog.getThumbnailImage());
            blog.setAuthor(updatedBlog.getAuthor());
            blog.setCategory(updatedBlog.getCategory());
            blog.setTags(updatedBlog.getTags());
            blog.setStatus(updatedBlog.getStatus());
            blog.setReadTime(updatedBlog.getReadTime());
            blog.setMetaTitle(updatedBlog.getMetaTitle());
            blog.setMetaDescription(updatedBlog.getMetaDescription());
            blog.setUpdated_On(LocalDateTime.now());
            return blogRepository.save(blog);
        }).orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
    }

    public void deleteBlog(Long id) {
         blogRepository.deleteById(id);
    }

    
}



