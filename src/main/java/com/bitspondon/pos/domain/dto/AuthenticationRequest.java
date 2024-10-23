package com.bitspondon.pos.domain.dto;

/**
 * @author rokib.ahmed
 * @since 10/22/24
 */
public class AuthenticationRequest {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
