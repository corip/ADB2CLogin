package com.login.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseValidateUser {

    private boolean isValidUser;
    private String displayName;
    private String givenName;
    private String surname;
    private String role;
    private String jti;

    private String userPrincipalName;

    private String objectId;

    private boolean isFirstLogin;

    private String userCredentialId;

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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(boolean firstLogin) {
        isFirstLogin = firstLogin;
    }

    public String getUserCredentialId() {
        return userCredentialId;
    }

    public void setUserCredentialId(String userCredentialId) {
        this.userCredentialId = userCredentialId;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
