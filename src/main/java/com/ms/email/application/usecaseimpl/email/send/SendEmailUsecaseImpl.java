package com.ms.email.application.usecaseimpl.email.send;

import com.ms.email.application.gateway.email.EmailGateway;
import com.ms.email.infra.entity.EmailEntity;
import com.ms.email.usecase.email.send.SendEmailUsecase;

public class SendEmailUsecaseImpl implements SendEmailUsecase {

    private final EmailGateway emailGateway;

    public SendEmailUsecaseImpl(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    @Override
    public EmailEntity execute(EmailEntity emailEntity) {
        return emailGateway.sendEmail(emailEntity);
    }
}
