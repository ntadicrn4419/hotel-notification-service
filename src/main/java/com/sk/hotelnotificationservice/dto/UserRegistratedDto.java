package com.sk.hotelnotificationservice.dto;

public class UserRegistratedDto {
    private Long userId;

    public UserRegistratedDto(Long userId) {
        this.userId = userId;
    }

    public UserRegistratedDto(){

    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
