package com.from.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

    @Autowired
    private UserRepository userRepo;

    public boolean addUser(User user) {
        // Check if user already exists
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return false;
        }
        userRepo.save(user);
        return true;
    }

    public User loginUser(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        // Checking if user exists
        if (existingUser == null) {
            return null;
        }
        // Checking if password matches
        if(existingUser.getPassword().equals(user.getPassword())) {
            return existingUser;
        } else {
            return null;
        }

    }

}
