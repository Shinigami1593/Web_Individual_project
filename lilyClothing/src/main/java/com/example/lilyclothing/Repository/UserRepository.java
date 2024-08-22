package com.example.lilyclothing.Repository;

import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lilyclothing.Entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}

