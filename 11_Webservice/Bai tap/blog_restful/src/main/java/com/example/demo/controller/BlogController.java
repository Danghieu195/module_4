package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> findAllBlogs() {
        List<Blog> blogs = iBlogService.findAll();

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> findBlogByID(@PathVariable Integer id) {
        Optional<Blog> blogOptional = iBlogService.findByID(id);

        if (!blogOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> categories = iCategoryRepository.findAll();

        if (categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<Blog>> findBlogsByCategoryID(@PathVariable Integer id) {
        List<Blog> blogs = iBlogService.findAllByCategory_Id(id);

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

}
