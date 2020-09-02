package com.ru.springReact.service;

import com.ru.springReact.model.User;
import com.ru.springReact.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User newUser = userRepository.getOne(user.getId());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setRole(user.getRole());
        newUser.setUsername(user.getUsername());

        return newUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}