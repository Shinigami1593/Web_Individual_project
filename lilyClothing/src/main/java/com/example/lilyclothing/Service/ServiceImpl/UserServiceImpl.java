package com.example.lilyclothing.Service.ServiceImpl;


import com.example.lilyclothing.Entity.User;
import com.example.lilyclothing.Pojo.UserPojo;
import com.example.lilyclothing.Repository.UserRepository;
import com.example.lilyclothing.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveData(UserPojo userPojo) {
        User user = new User();
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setAddress(userPojo.getAddress());
        user.setPhone(userPojo.getPhone());
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User updateUser(Long id, UserPojo userPojo) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setAddress(userPojo.getAddress());
        user.setPhone(userPojo.getPhone());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


