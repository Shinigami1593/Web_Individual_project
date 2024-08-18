package com.example.lilyclothing.Controller;


import com.example.lilyclothing.Entity.User;
import com.example.lilyclothing.Pojo.AuthPojo;
import com.example.lilyclothing.Pojo.UserPojo;
import com.example.lilyclothing.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app_users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody UserPojo userPojo) {

        userService.saveData(userPojo);
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<Long> login(@RequestBody AuthPojo request) {
        String username = request.getUsername();
        String password = request.getPassword();
        User user = userService.login(username, password);

        if (user != null) {
            return ResponseEntity.ok(user.getId());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserPojo userPojo) {
        return userService.updateUser(id, userPojo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
