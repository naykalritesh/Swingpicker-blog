package com.auxirem.blogs.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auxirem.blogs.Model.Blog;
import com.auxirem.blogs.Services.BlogService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/blogs")
public class BlogController {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;

    // Get all blogs
    @GetMapping("/all")
    public List<Blog> getAllBlogs() {
        logger.info("Fetching all blogs");
        return blogService.getAllBlogs();
    }

    //Get Blog by id
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id){
        logger.info("Fetching blog with Id:",id);
        return blogService.getBlogById(id);
    }

    // create new blog
    @PostMapping("/add")
    public Blog createNewBlog(@RequestBody Blog blog){
        logger.info("Creating new blog with title:",blog.getTitle());
        logger.debug("Thumbnail image:",blog.getThumbnailImage());
        return blogService.createNewBlog(blog);
    }
        
    //update blog
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id,@RequestBody Blog blog){
        logger.info("updating blog with id:", id);
        return blogService.updateBlog(id, blog);
    }
     
    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id){
        logger.info("Deleting blog with id:", id);
        blogService.deleteBlog(id);
        return "Blog with ID " + id + " deleted successfully.";
    }


}

