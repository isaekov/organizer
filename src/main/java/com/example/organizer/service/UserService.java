package com.example.organizer.service;

import com.example.organizer.entity.User;
import com.example.organizer.rpository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {

        userRepository.save(user);

    }


}
