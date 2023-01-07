package com.example.rabbit.service;

import com.example.rabbit.client.MailSenderClient;
import com.example.rabbit.model.EmailDto;
import com.example.rabbit.model.MailModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final MailSenderClient mailSenderClient;

    public void sendMail(EmailDto emailDto) {
        log.info("ActionLog.SendMail.Started");
        log.info("ActionLog.CallMSMailSender.Started");
        mailSenderClient.sendMail(emailDto);
        log.info("ActionLog.CallMSMailSender.Finished");
        log.info("ActionLog.SendMail.Finished");
    }
}
