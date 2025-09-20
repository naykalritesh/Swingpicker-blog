package com.auxirem.blogs.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxirem.blogs.Model.Blog;
import com.auxirem.blogs.Repository.BlogRepository;

@Service
public class BlogService {
  private static final Logger logger = LoggerFactory.getLogger(BlogService.class);

    @Autowired
    private BlogRepository blogRepository;

    // Get all blogs
    public List<Blog> getAllBlogs() {
        logger.info("Fetching all blogs from repository");
        return blogRepository.findAll();
    }
    public Blog getBlogById(Long id) {
        logger.info("Fetching blog with id:",id);
        Optional<Blog> existingBlog = blogRepository.findById(id);
        if (existingBlog.isPresent()) {
            logger.info("Blog found with id:", id);
           return  existingBlog.get();
        }else{
            logger.info("Blog not found with id:", id);
            return null;
           
        }
    
    }

    public Blog createNewBlog(Blog blog){
        blog.setCreated_On(LocalDateTime.now());
        blog.setUpdated_On(LocalDateTime.now());
        logger.info("Creating new blog with title:", blog.getTitle());
        return  blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        logger.info("Updating blog with id:", id);
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
            logger.info("Blog updated successfully with id:", id);
            return blogRepository.save(blog);
        }).orElseThrow(() -> {
            logger.error("Blog not found with id:", id);
            return new RuntimeException("Blog not found with id " + id);});
    }

    public void deleteBlog(Long id) {
        logger.info("Deleting blog with id:",id);
        blogRepository.deleteById(id);
        logger.info("Blog deleted successfully with id:", id);
    }

    
}



