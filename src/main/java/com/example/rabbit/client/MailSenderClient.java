package com.example.rabbit.client;

import com.example.rabbit.model.EmailDto;
import com.example.rabbit.model.MailModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-mail-sender",url = "http://localhost:8082")
public interface MailSenderClient {
    @PostMapping("v1/send-mail")
    void sendMail(@RequestBody EmailDto emailDto);
}
