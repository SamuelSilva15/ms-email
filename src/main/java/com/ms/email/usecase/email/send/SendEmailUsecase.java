package com.ms.email.usecase.email.send;

import com.ms.email.infra.entity.EmailEntity;

public interface SendEmailUsecase {
    EmailEntity execute(EmailEntity emailEntity);
}
