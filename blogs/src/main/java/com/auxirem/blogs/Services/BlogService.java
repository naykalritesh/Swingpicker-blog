package com.auxirem.blogs.Services;

import java.util.List;

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

    public Blog createNewBlog(Blog blog){
        return  blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
       return blogRepository.findById(id).map(blog -> {
            blog.setTitle(updatedBlog.getTitle());
            blog.setDescription(updatedBlog.getDescription());
            blog.setImages(updatedBlog.getImages());
            blog.setAuthor(updatedBlog.getAuthor());
            blog.setCategory(updatedBlog.getCategory());
            blog.setTags(updatedBlog.getTags());
            blog.setStatus(updatedBlog.getStatus());
            blog.setReadTime(updatedBlog.getReadTime());
            blog.setMetaTitle(updatedBlog.getMetaTitle());
            blog.setMetaDescription(updatedBlog.getMetaDescription());
            return blogRepository.save(blog);
        }).orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
    }

    public void deleteBlog(Long id) {
         blogRepository.deleteById(id);
    }
}
