package com.example.lilyclothing.Service;

import com.example.lilyclothing.Entity.User;
import com.example.lilyclothing.Pojo.UserPojo;

import java.util.List;

public interface UserService {
    void saveData(UserPojo userPojo);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User login(String username, String password);
    User updateUser(Long id, UserPojo userPojo);
    void deleteUser(Long id);
}
