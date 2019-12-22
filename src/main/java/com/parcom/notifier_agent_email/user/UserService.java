package com.parcom.notifier_agent_email.user;

import org.springframework.security.access.annotation.Secured;

public interface UserService {
    @Secured({"ROLE_ADMIN","ROLE_MEMBER"})
    User getById(Long id);
}
