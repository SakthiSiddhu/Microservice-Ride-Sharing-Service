package com.ust.userservice.controller;

import com.ust.userservice.model.User;
import com.ust.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
      public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/addall")
    public List<User> createUsers(@RequestBody List<User> users){

        return userService.createUsers(users);
    }

    @GetMapping("/allusers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){

        return userService.getUserById(id);
    }


}
