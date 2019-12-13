package com.parcom.notifier_agent_email.notification;

import com.parcom.notifier_agent_email.user.User;
import com.parcom.notifier_agent_email.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final UserService userService;

    void send(NotificationAgentDto notificationDto) {

        User user = userService.getById(notificationDto.getIdUserReciever());
        if (user.getEmail() != null) {

            log.info("Send email to \"{}\" ",user.getEmail());
            log.info("Type:  \"{}\" Title: \" {}\"",notificationDto.getNotificationType(),notificationDto.getTitle());
            log.info("Message:  \"{}\"",notificationDto.getMessage());
        }
        else
            log.info("Can't send email for user id  {}. Email field is empty",user.getId());


    }



}
