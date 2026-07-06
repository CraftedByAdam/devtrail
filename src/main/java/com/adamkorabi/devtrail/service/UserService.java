package com.adamkorabi.devtrail.service;

import com.adamkorabi.devtrail.exception.DuplicateUsernameException;
import com.adamkorabi.devtrail.model.User;
import com.adamkorabi.devtrail.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            throw new DuplicateUsernameException("Username already exists.");
        }
        return userRepository.save(user);
    }
}
