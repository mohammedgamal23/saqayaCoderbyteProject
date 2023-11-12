package com.example.saqayaCoderbyteProject.service;

import com.example.saqayaCoderbyteProject.model.User;
import com.example.saqayaCoderbyteProject.repo.UserRepository;
import com.example.saqayaCoderbyteProject.config.SHA1HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);

    }

    public User generateUserId(User user){
        user.setId(SHA1HashGenerator.generateHash(user.getEmail()));
        return user;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}

