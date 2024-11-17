package com.ms.email.infra.service;

import com.ms.email.application.gateway.email.EmailGateway;
import com.ms.email.core.domain.email.enums.StatusEmail;
import com.ms.email.infra.entity.EmailEntity;
import com.ms.email.infra.repositories.EmailRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailGatewayImpl implements EmailGateway {

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    public EmailGatewayImpl(EmailRepository emailRepository, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Override
    public EmailEntity sendEmail(EmailEntity email) {
        try {
            email.setEmailFrom(emailFrom);
            email.setSendDateEmail(LocalDateTime.now());

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email.getEmailTo());
            mailMessage.setSubject(email.getSubject());
            mailMessage.setText(email.getText());
            mailSender.send(mailMessage);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }
}