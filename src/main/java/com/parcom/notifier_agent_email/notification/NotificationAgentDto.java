package com.parcom.notifier_agent_email.notification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class NotificationAgentDto  {

    @NotNull
    private  final NotificationType notificationType;

    @NotNull
    private final String  title;

    private final String  message;

    @NotNull
    private final Long idObjectSender;

    @NotNull
    private final Long idUserSender;

    @NotNull
    private final Long idUserReciever;


}
