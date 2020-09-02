package com.ru.springReact.repository;

import com.ru.springReact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional <User> findByName(String name);
    User save(User user);
    void deleteById(Long id);
    List<User> findAll();
}
