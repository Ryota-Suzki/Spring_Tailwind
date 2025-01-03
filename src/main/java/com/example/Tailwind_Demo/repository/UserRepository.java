package com.example.Tailwind_Demo.repository;

import com.example.Tailwind_Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
