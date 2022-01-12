package com.sk.hotelnotificationservice.service;

import com.sk.hotelnotificationservice.dto.NotificationDto;
import org.springframework.stereotype.Component;

@Component
public interface NotificationService {
    void sendActivationEmail(NotificationDto dto);
}
