package com.login.entity;

public class Request {

    private String email;
    private String language;
    private Long loyaltyId;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getLoyaltyId() {
        return loyaltyId;
    }

    public void setLoyaltyId(Long loyaltyId) {
        this.loyaltyId = loyaltyId;
    }
}
