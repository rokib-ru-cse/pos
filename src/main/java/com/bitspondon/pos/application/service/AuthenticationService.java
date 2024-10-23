package com.bitspondon.pos.application.service;

import com.bitspondon.pos.application.repository.UserRepository;
import com.bitspondon.pos.domain.dto.AuthenticationRequest;
import com.bitspondon.pos.domain.entities.User;
import com.bitspondon.pos.presentation.security.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/22/24
 */
@Component
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void createAdmin(User user) {
//        User user = User.builder().firstname(request.getFirstname()).lastname(request.getLastname()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Constant.ROLE_ADMIN).build();

        user = userRepository.save(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public String createUser(User user) {
        user = userRepository.save(user);

        return jwtUtils.generateToken(user);
    }

    public String authenticate(AuthenticationRequest request, HttpServletRequest http) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail());

        String jwtToken = jwtUtils.generateToken(user);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(http));

            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        return jwtToken;
    }
}
