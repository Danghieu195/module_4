package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findByID(Integer id);
}
