package com.sk.hotelnotificationservice.service.impl;

import com.sk.hotelnotificationservice.dto.NotificationDto;
import com.sk.hotelnotificationservice.repository.NotificationRepository;
import com.sk.hotelnotificationservice.service.NotificationService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService{

    private NotificationRepository notificationRepository;
    private JavaMailSender mailSender;

    public NotificationServiceImpl(NotificationRepository notificationRepository, JavaMailSender mailSender) {
        this.notificationRepository = notificationRepository;
        this.mailSender = mailSender;
    }

    @Override
    public void sendActivationEmail(NotificationDto dto) {
//        notificationRepository.findById(dto.getUserId()) // da li mi ovo treba uopste?
//                .ifPresent(notification->{                // cemu mi sluzi notificationRepository?
//                    //posaljemo mail tj. notifikaciju sa podacima iz dto
//
//                });
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hotelnotificationservice@gmail.com");
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        message.setText(dto.getContent());
        mailSender.send(message);
    }
}
