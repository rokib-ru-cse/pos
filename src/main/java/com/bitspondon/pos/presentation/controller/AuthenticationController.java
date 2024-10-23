package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.AuthenticationService;
import com.bitspondon.pos.domain.dto.AuthenticationRequest;
import com.bitspondon.pos.domain.dto.RegisterRequest;
import com.bitspondon.pos.domain.entities.User;
import com.bitspondon.pos.domain.helper.UserHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rokib.ahmed
 * @since 10/22/24
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserHelper userHelper;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        User user = userHelper.getUserFromRequest(request);

        return ResponseEntity.ok(authenticationService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request, HttpServletRequest http) {
        return ResponseEntity.ok(authenticationService.authenticate(request, http));
    }
}
