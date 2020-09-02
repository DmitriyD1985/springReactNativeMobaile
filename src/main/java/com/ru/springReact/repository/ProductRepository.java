package com.ru.springReact.repository;

import com.ru.springReact.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Optional<Product> findById(Long id);
    void deleteById(Long id);
    List<Product> findAll();
}
