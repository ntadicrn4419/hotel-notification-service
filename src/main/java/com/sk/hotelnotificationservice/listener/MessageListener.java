package com.sk.hotelnotificationservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.hotelnotificationservice.dto.NotificationDto;
import com.sk.hotelnotificationservice.service.NotificationService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MessageListener {

    private ObjectMapper objectMapper;
    private NotificationService notificationService;

    public MessageListener(ObjectMapper objectMapper, NotificationService notificationService) {
        this.objectMapper = objectMapper;
        this.notificationService = notificationService;
    }
    @JmsListener(destination = "${destination.message}", concurrency = "5-10")
    public void notificationMessage(Message message) throws JMSException, JsonProcessingException {
        String json = ((TextMessage)message).getText();
        NotificationDto dto = objectMapper.readValue(json, NotificationDto.class);

        if(dto.getType().equals("ACTIVATION_EMAIL")){
            notificationService.sendActivationEmail(dto);
            return;
        }
        if(dto.getType().equals("RESET_PASSWORD_EMAIL")){
            notificationService.sendResetPasswordEmail(dto);
            return;
        }
        if(dto.getType().equals("SUCCESSFUL_RESERVATION_EMAIL")){
            notificationService.sendSuccessfulReservationEmail(dto);
//            //ovako treba da izgleda dto koji reservation service treba da posalje
//            NotificationDto dtoProba = new NotificationDto(2, "tadic.nikola00@gmail.com", "proba", "SUCCESSFUL_RESERVATION_EMAIL",
//                    "Milorad", "Milinkovic", "Zika", "Pavlovic",
//                    "nikola091291@gmail.com", Instant.now().plus(1, ChronoUnit.DAYS));
//            notificationService.sendSuccessfulReservationEmail(dtoProba);
            return;
        }
        if(dto.getType().equals("CANCEL_RESERVATION_EMAIL")){
            notificationService.sendCancelReservationEmail(dto);
            return;
        }
    }
}
