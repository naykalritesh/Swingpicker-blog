package com.auxirem.blogs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // Get all blogs
    @GetMapping("/all")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    //Get Blog by id
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id){
        return blogService.getBlogById(id);
    }

    // create new blog
    @PostMapping("/add")
    public Blog createNewBlog(@RequestBody Blog blog){
        return blogService.createNewBlog(blog);
    }
    
    //update blog
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id,@RequestBody Blog blog){
        return blogService.updateBlog(id, blog);
    }
     
    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id){
        blogService.deleteBlog(id);
        return "Blog with ID " + id + " deleted successfully.";
    }

}

