package com.example.meeting_scheduler.services;

import com.example.meeting_scheduler.model.User;
import com.example.meeting_scheduler.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(){
        this.userRepository = UserRepository.getInstance();
    }

    public boolean addUser(User user) {
        return this.userRepository.addUser(user);
    }

    public User getUserByEmail(String email) {
        return this.getUserByEmail(email);
    }

}
