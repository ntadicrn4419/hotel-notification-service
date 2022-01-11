package com.sk.hotelnotificationservice.service.impl;

import com.sk.hotelnotificationservice.dto.UserRegistratedDto;
import com.sk.hotelnotificationservice.repository.NotificationRepository;
import com.sk.hotelnotificationservice.service.NotificationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService{

    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendActivationEmail(UserRegistratedDto dto) {
//        notificationRepository.findById(dto.getUserId())
//                .ifPresent(notification->{
//                    //posaljemo mail tj. notifikaciju sa podacima iz dto
//
//                });
        System.out.println("implementirati slanje maila tj. notifikacije sa podacima iz dto; userId iz dto-a je " + dto.getUserId());
    }
}
