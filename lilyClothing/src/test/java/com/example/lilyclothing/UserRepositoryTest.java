package com.example.lilyclothing;

import com.example.lilyclothing.Entity.User;
import com.example.lilyclothing.Repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {
        User user = User.builder()
                .username("johndoe")
                .password("password123")
                .address("123 Main St")
                .phone(1234567890L)
                .build();

        userRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest() {
        User userCreated = userRepository.findById(1L).orElse(null);
        Assertions.assertThat(userCreated).isNotNull();
        Assertions.assertThat(userCreated.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfUsersTest() {
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userRepository.findById(1L).orElse(null);
        if (user != null) {
            user.setUsername("janedoe");
            user.setPassword("newpassword123");

            User userUpdated = userRepository.save(user);

            Assertions.assertThat(userUpdated.getUsername()).isEqualTo("janedoe");
            Assertions.assertThat(userUpdated.getPassword()).isEqualTo("newpassword123");
        }
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest() {
        User user = userRepository.findById(1L).orElse(null);
        if (user != null) {
            userRepository.delete(user);

            Optional<User> optionalUser = userRepository.findById(1L);
            Assertions.assertThat(optionalUser).isEmpty();
        }
    }
}
