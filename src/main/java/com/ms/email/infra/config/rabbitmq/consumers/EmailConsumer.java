package com.ms.email.infra.config.rabbitmq.consumers;

import com.ms.email.core.domain.email.save.SaveEmailInput;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload SaveEmailInput saveEmailInput) {
        System.out.println(saveEmailInput.emailTo());
    }
}
