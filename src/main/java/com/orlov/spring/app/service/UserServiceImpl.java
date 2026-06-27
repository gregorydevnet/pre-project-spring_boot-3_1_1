package com.orlov.spring.app.service;

import com.orlov.spring.app.model.User;
import com.orlov.spring.app.repository.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User не может быть null");
        }
        userDao.save(user);
    }

    @Override
    public User getUser(Long id) {
        User user = userDao.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User с ID: " + id + " не найден");
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("Для обновления требуется пользователь с ID");
        }
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID не может быть нулевым");
        }
        userDao.deleteById(id);
    }
}
