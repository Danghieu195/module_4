package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAllByAuthor(String author, Pageable pageable);

    Page<Blog> findAllByCategory_Id(Integer categoryID, Pageable pageable);

    Page<Blog> findAllByCategory_IdAndAuthor(Integer categoryID, String author, Pageable pageable);
}
