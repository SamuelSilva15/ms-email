package com.ms.email.core.domain.email.send;

import java.util.UUID;

public record SendEmailInput(UUID userId, String emailTo, String subject, String text) { }
