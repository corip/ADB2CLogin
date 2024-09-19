package com.login.entity;

public class RequestValidateUser {

    private String signInName;
    private String password;

    private String userCredentialId;




    public String getSignInName() {
        return signInName;
    }

    public void setSignInName(String signInName) {
        this.signInName = signInName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCredentialId() {
        return userCredentialId;
    }

    public void setUserCredentialId(String userCredentialId) {
        this.userCredentialId = userCredentialId;
    }
}
