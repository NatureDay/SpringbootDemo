package com.example.demo.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 采用token实现
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken() {
    }

    public JwtToken(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
