package com.example.lilyclothing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lilyclothing.Entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}

