package com.example.lilyclothing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lilyclothing.Entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE username = ?1 AND password = ?2")
    User findByUsernameAndPassword(String username, String password);
}

