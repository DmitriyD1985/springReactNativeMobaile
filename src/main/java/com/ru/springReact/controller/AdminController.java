package com.ru.springReact.controller;

import com.ru.springReact.model.Product;
import com.ru.springReact.model.User;
import com.ru.springReact.service.ProductService;
import com.ru.springReact.service.TransactionService;
import com.ru.springReact.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    UserService userService;
    ProductService productService;
    TransactionService transactionService;

    public AdminController(UserService userService, ProductService productService, TransactionService transactionService) {
        this.userService = userService;
        this.productService = productService;
        this.transactionService = transactionService;
    }

    @PutMapping("api/admin/update-user")
    public ResponseEntity<User> update(User user) {
        User existUser = userService.findByName(user.getUsername()).orElse(null);

        if (existUser != null && user.getId().equals(existUser.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.update(user), HttpStatus.CREATED);
    }

    @GetMapping("api/admin/delete-user")
    public ResponseEntity<User> deleteUser(User user) {
        userService.delete(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("api/admin/getAll-user")
    public ResponseEntity<List<User>> getAlleUsers(User user) {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("api/admin/count-user")
    public ResponseEntity<Long> countUser() {
        return new ResponseEntity<>((long) userService.findAll().size(), HttpStatus.OK);
    }

    @PostMapping("api/admin/create-product")
    public ResponseEntity<Product> createProduct(Product product) {
        return new ResponseEntity<>( productService.save(product), HttpStatus.OK);
    }

    @PostMapping("api/admin/update-product")
    public ResponseEntity<Product> updateProduct(Product product) {
        return new ResponseEntity<>( productService.save(product), HttpStatus.OK);
    }

}
