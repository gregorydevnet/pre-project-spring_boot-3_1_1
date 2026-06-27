package com.orlov.spring.app.service;

import com.orlov.spring.app.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUser(Long id);

    List<User> getUsers();

    void updateUser(User user);

    void deleteUser(Long id);
}
