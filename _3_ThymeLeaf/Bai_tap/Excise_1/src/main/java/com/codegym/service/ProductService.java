package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements ProductServiceImpl {
    
    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Co gai Ha Lan", "milk", 16000));
        products.put(2, new Product(2, "Iphone 13 pro max", "smart phone", 36000000));
        products.put(3, new Product(3, "MacBook Air", "laptop", 26000000));
        products.put(4, new Product(4, "Mi miniket", "noodle", 5000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findByID(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> searchByName(String name) {
        return null;
    }
}
