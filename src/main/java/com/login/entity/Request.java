package com.login.entity;

public class Request {

    private String email;
    private String password;
    private String userCredentialId;
    private String jti;

    private String objectId;


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

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
