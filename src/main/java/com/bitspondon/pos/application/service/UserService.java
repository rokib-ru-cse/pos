package com.bitspondon.pos.application.service;

import com.bitspondon.pos.application.repository.UserRepository;
import com.bitspondon.pos.domain.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(@Valid User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
