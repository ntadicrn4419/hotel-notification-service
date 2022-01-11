package com.sk.hotelnotificationservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.hotelnotificationservice.dto.UserRegistratedDto;
import com.sk.hotelnotificationservice.service.NotificationService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class UserRegistratedMessageListener {

    private ObjectMapper objectMapper;
    private NotificationService notificationService;

    public UserRegistratedMessageListener(ObjectMapper objectMapper, NotificationService notificationService) {
        this.objectMapper = objectMapper;
        this.notificationService = notificationService;
    }

    @JmsListener(destination = "${destination.user.registrated.message}", concurrency = "5-10")
    public void userRegistratedMessage(Message message) throws JMSException, JsonProcessingException {
        String json = ((TextMessage)message).getText();
        UserRegistratedDto dto = objectMapper.readValue(json, UserRegistratedDto.class);
        System.out.println("OVO JE DTO, userid iz dto-a je " + dto.getUserId());
        System.out.println(dto);
        notificationService.sendActivationEmail(dto);
    }
}
