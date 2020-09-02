package com.ru.springReact.controller;

import com.ru.springReact.model.Role;
import com.ru.springReact.model.Transaction;
import com.ru.springReact.model.User;
import com.ru.springReact.service.ProductService;
import com.ru.springReact.service.TransactionService;
import com.ru.springReact.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.Instant;

@RestController
public class UserController {
    private final UserService userService;
    private final ProductService productService;
    private final TransactionService transactionService;

    public UserController(UserService userService, ProductService productService,
                          TransactionService transactionService) {
        this.userService = userService;
        this.productService = productService;
        this.transactionService = transactionService;
    }

    @PostMapping("api/user/registration")
    public ResponseEntity<?> registration(@RequestBody User user)
    {
        if(userService.findByName(user.getUsername()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }


    @GetMapping("api/user/login")
    public ResponseEntity<?> getUser(Principal principal)
    {
        if(principal == null || principal.getName() == null)
        {
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findByName(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("api/user/purchase")
    public ResponseEntity<?> purchase(Transaction transaction)
    {
       transaction.setCreatedAt(Instant.now());
       return new ResponseEntity<>(transactionService.save(transaction), HttpStatus.CREATED);
    }

    @GetMapping("api/user/product")
    public ResponseEntity<?> getAllProduct()
    {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
