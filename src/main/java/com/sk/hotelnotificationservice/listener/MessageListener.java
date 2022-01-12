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

    @JmsListener(destination = "${destination.user.registrated.message}", concurrency = "5-10")
    public void userRegistratedMessage(Message message) throws JMSException, JsonProcessingException {
        String json = ((TextMessage)message).getText();
        NotificationDto dto = objectMapper.readValue(json, NotificationDto.class);
        notificationService.sendActivationEmail(dto);
    }
}
