package com.orlov.spring.app.repository;

import com.orlov.spring.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User getUserById(Long id);
}
