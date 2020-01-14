package com.parcom.notifier_agent_email.notification;

import com.parcom.asyncdto.NotificationAgentDto;
import com.parcom.notifier_agent_email.user.User;
import com.parcom.notifier_agent_email.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final UserService userService;

    @Override
    public void send(NotificationAgentDto notificationAgentDto) {

        User user = userService.getById(notificationAgentDto.getIdUserReceiver());
        if (user.getEmail() != null) {

            log.info("Send email to \"{}\" ",user.getEmail());
            log.info("Type:  \"{}\" Title: \" {}\"", notificationAgentDto.getNotificationType(), notificationAgentDto.getTitle());
            log.info("Message:  \"{}\"", notificationAgentDto.getMessage());
        }
        else
            log.info("Can't send email for user id  {}. Email field is empty",user.getId());


    }



}
