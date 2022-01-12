package com.sk.hotelnotificationservice.service;

import com.sk.hotelnotificationservice.domain.Notification;
import com.sk.hotelnotificationservice.domain.NotificationType;
import com.sk.hotelnotificationservice.dto.NotificationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface NotificationService {
    List<Notification> findNotificationsByEmail(String email);
    List<Notification> findNotificationsByType(String notificationType);

    Page<Notification> findAll(Pageable pageable);
    void sendActivationEmail(NotificationDto dto);
    void sendResetPasswordEmail(NotificationDto dto);
    void sendSuccessfulReservationEmail(NotificationDto dto);
    void sendCancelReservationEmail(NotificationDto dto);
    void send2DaysReminderEmail(NotificationDto dto);
}
