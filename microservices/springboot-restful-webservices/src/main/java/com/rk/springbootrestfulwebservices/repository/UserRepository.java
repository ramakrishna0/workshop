package com.rk.springbootrestfulwebservices.repository;

import com.rk.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
