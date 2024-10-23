package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.dto.RegisterRequest;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class UserHelper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean checkAccess(User user, String requiredRole) {
        return user.getRoles().stream()
                .anyMatch(role -> role.getName().equals(requiredRole));
    }

    public User getUserFromRequest(RegisterRequest request) {
//        org.springframework.security.core.userdetails.User user1 = org.springframework.security.core.userdetails.User.builder().
//        (request.getFirstname()).lastname(request.getLastname()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Constant.ROLE_ADMIN).build();
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        return user;
    }
}