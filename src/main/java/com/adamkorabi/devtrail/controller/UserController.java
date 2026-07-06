package com.adamkorabi.devtrail.controller;

import com.adamkorabi.devtrail.model.User;
import com.adamkorabi.devtrail.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User creatUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
