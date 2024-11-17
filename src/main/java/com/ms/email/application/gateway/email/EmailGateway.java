package com.ms.email.application.gateway.email;

import com.ms.email.infra.entity.EmailEntity;

public interface EmailGateway {
    EmailEntity sendEmail(EmailEntity email);
}
