package com.login.entity;

public class Request {

    private String email;
    private String password;
    private String userCredentialId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserCredentialId() {
        return userCredentialId;
    }

    public void setUserCredentialId(String userCredentialId) {
        this.userCredentialId = userCredentialId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
