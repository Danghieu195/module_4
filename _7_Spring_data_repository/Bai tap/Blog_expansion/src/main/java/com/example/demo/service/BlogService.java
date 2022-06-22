package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll1(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findByID(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void remove(Integer id) {
        blogRepository.delete(findByID(id).get());
    }

    @Override
    public Page<Blog> findAllByAuthor(String author, Pageable pageable) {
        return blogRepository.findAllByAuthor(author, pageable);
    }

    @Override
    public Page<Blog> findAllByCategory_Id(Integer categoryID, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(categoryID, pageable);
    }

    @Override
    public Page<Blog> findAllByAuthorAndCategory_Id(String author, Integer categoryID, Pageable pageable) {
        return blogRepository.findAllByCategory_IdAndAuthor(categoryID, author, pageable);
    }


}
