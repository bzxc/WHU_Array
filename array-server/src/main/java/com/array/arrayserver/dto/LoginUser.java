package com.array.arrayserver.dto;

/**
 * @author yee
 */
public class LoginUser {
    private String username;
    private String password;
    private Boolean RememberMe;

    public LoginUser() {
    }

    public LoginUser(String username, String password, Boolean rememberMe) {
        this.username = username;
        this.password = password;
        RememberMe = rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return RememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        RememberMe = true;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", RememberMe=" + RememberMe +
                '}';
    }
}
