package com.ru.springReact.service;


import com.ru.springReact.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> findByName(String name);
    User save(User user);
    User update(User user);
    void delete(Long id);
    List<User> findAll();
}
