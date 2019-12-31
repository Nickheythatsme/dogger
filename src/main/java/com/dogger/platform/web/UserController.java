package com.dogger.platform.web;

import com.dogger.platform.domain.User;
import com.dogger.platform.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
