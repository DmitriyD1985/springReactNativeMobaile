package com.ru.springReact.service;

import com.ru.springReact.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product save(Product product);

    public Optional<Product> findById(Long id);

    public Product update (Product product);

    List<Product> findAll();
}
