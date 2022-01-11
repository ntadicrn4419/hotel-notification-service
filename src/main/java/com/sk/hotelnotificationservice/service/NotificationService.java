package com.sk.hotelnotificationservice.service;

import com.sk.hotelnotificationservice.dto.UserRegistratedDto;

public interface NotificationService {
    void sendActivationEmail(UserRegistratedDto dto);
}
