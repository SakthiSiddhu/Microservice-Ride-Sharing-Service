package com.ust.userservice.service;

import com.netflix.discovery.converters.Auto;
import com.ust.userservice.dto.UserDto;
import com.ust.userservice.model.User;
import com.ust.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {

        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return  userRepository.saveAll(users);
    }
}
