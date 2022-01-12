package com.sk.hotelnotificationservice.service.impl;

import com.sk.hotelnotificationservice.domain.Notification;
import com.sk.hotelnotificationservice.domain.NotificationType;
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
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hotelnotificationservice@gmail.com");
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        String content = "Pozdrav " + dto.getUserFirstName() + " " + dto.getUserLastName() + ", \n" + "Kliknite na link za aktiviranje naloga.";
        message.setText(content);
        mailSender.send(message);

        Notification notification = new Notification(dto.getTo(), dto.getSubject(), content, NotificationType.ACTIVATION_EMAIL);
        notificationRepository.save(notification);
    }

    @Override
    public void sendResetPasswordEmail(NotificationDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hotelnotificationservice@gmail.com");
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        String content = "Pozdrav " + dto.getUserFirstName() + " " + dto.getUserLastName() + ", \n" + "Uspesno ste resetovali svoju lozinku.";
        message.setText(content);
        mailSender.send(message);

        Notification notification = new Notification(dto.getTo(), dto.getSubject(), content, NotificationType.RESET_PASSWORD_EMAIL);
        notificationRepository.save(notification);
    }

    @Override
    public void sendSuccessfullReservationEmail(NotificationDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hotelnotificationservice@gmail.com");
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        String content = "Pozdrav " + dto.getUserFirstName() + " " + dto.getUserLastName() + ", \n" + "Uspesno ste rezervisali smestaj.";
        message.setText(content);
        mailSender.send(message);

        Notification notification = new Notification(dto.getTo(), dto.getSubject(), content, NotificationType.SUCCESSFUL_RESERVATION_EMAIL);
        notificationRepository.save(notification);
    }

    @Override
    public void sendCancelReservationEmail(NotificationDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hotelnotificationservice@gmail.com");
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        String content = "Pozdrav " + dto.getUserFirstName() + " " + dto.getUserLastName() + ", \n" + "Uspesno ste otkazali rezervaciju.";
        message.setText(content);
        mailSender.send(message);

        Notification notification = new Notification(dto.getTo(), dto.getSubject(), content, NotificationType.CANCEL_RESERVATION_EMAIL);
        notificationRepository.save(notification);
    }

    @Override
    public void send2DaysReminderEmail(NotificationDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hotelnotificationservice@gmail.com");
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        String content = "Pozdrav " + dto.getUserFirstName() + " " + dto.getUserLastName() + ", \n" + "Ostalo je dva dana do vase rezervacije.";
        message.setText(content);
        mailSender.send(message);

        Notification notification = new Notification(dto.getTo(), dto.getSubject(), content, NotificationType.TWO_DAYS_REMINDER_EMAIL);
        notificationRepository.save(notification);
    }
}
