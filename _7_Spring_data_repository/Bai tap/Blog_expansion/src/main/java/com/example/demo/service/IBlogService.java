package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IBlogService {
    public Iterable<Blog> findAll1(Pageable pageable);

    public Page<Blog> findAll(Pageable pageable);

    public Optional<Blog> findByID(Integer id);

    public void save(Blog blog);

    public void remove(Integer id);

    Page<Blog> findAllByAuthor(String author,Pageable pageable);

    Page<Blog> findAllByCategory_Id(Integer categoryID,Pageable pageable);

    Page<Blog> findAllByAuthorAndCategory_Id(String author,Integer categoryID,Pageable pageable);
}
