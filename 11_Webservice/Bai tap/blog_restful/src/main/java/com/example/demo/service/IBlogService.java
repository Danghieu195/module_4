package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findByID(Integer id);

    Blog save(Blog blog);

    void remove(Integer id);

    List<Blog> findAllByCategory_Id(Integer categoryID);
}
