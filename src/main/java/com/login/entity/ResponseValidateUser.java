package com.login.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseValidateUser {

    private boolean isValidUser;
    private String displayName;
    private String givenName;
    private String surname;

    private String userPrincipalName;

    public boolean getIsValidUser() {
        return isValidUser;
    }

    public void setIsValidUser(boolean ValidUser) {
        isValidUser = ValidUser;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }
}
