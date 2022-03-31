package com.jcy.wecando.entity.user.repository;

import com.jcy.wecando.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(Long id);
    Optional<User> findById(Long id);
    void deleteById(Long id);
}