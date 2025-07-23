package com.example.ExaminationSystem.service;

import com.example.ExaminationSystem.model.User;
import com.example.ExaminationSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> login(String usernameOrEmail, String rawPassword) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()));
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }

}

