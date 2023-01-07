package com.example.rabbit.queue;

import com.example.rabbit.model.EmailDto;
import com.example.rabbit.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Listener {
    private final EmailService emailService;
    private final ObjectMapper objectMapper;
    @RabbitListener(queues = "${rabbitmq.queue.test}")
    public void receiveMessage(String message) {
        log.info("ActionLog.receiveMessage.start message: {}", message);

        try {
            var mail = objectMapper.readValue(message, EmailDto.class);
            emailService.sendMail(mail);
            System.out.println(mail.getMail());
        } catch (Exception ex) {
            log.error("ActionLog.receiveMessage.error: ", ex);
        }
    }
}
