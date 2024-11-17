package com.ms.email.infra.config.email;

import com.ms.email.application.gateway.email.EmailGateway;
import com.ms.email.application.usecaseimpl.email.send.SendEmailUsecaseImpl;
import com.ms.email.usecase.email.send.SendEmailUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    @Bean
    public SendEmailUsecase sendEmail(EmailGateway emailGateway) {
        return new SendEmailUsecaseImpl(emailGateway);
    }
}
