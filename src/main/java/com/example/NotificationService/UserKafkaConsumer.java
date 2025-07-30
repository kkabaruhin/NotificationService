package com.example.NotificationService;

import com.example.NotificationService.mail.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserKafkaConsumer {

    @Autowired
    MailSenderService mailSenderService;

    @KafkaListener(topics = "create")
    public void consumeUserCreate(UserDto userDto) {
        System.out.println("User: " + userDto + " created");
        mailSenderService.sendHello(userDto);

    }

    @KafkaListener(topics = "delete")
    public void consumeUserDelete(UserDto userDto) {
        System.out.println("Received User: " + userDto + " deleted");
        mailSenderService.sendGoodBy(userDto);
    }
}
