package com.sk.hotelnotificationservice.service;

import com.sk.hotelnotificationservice.dto.NotificationDto;
import org.springframework.stereotype.Component;

@Component
public interface NotificationService {
    void sendActivationEmail(NotificationDto dto);
    void sendResetPasswordEmail(NotificationDto dto);
    void sendSuccessfullReservationEmail(NotificationDto dto);
    void sendCancelReservationEmail(NotificationDto dto);
    void send2DaysReminderEmail(NotificationDto dto);
}
