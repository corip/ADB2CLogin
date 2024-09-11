package com.login.entity;

public class RequestValidateUser {

    private String signInName;
    private String password;

    private String email;




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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
