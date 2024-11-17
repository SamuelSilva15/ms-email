package com.ms.email.infra.config.rabbitmq.consumers;

import com.ms.email.core.domain.email.send.SendEmailInput;
import com.ms.email.infra.entity.EmailEntity;
import com.ms.email.usecase.email.send.SendEmailUsecase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final SendEmailUsecase sendEmailUsecase;

    public EmailConsumer(SendEmailUsecase sendEmailUsecase) {
        this.sendEmailUsecase = sendEmailUsecase;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload SendEmailInput sendEmailInput) {
        var emailEntity = new EmailEntity();
        BeanUtils.copyProperties(sendEmailInput, emailEntity);
        sendEmailUsecase.execute(emailEntity);
    }
}
