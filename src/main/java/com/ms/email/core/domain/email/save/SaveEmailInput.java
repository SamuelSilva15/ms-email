package com.ms.email.core.domain.email.save;

import java.util.UUID;

public record SaveEmailInput(UUID userId, String emailTo, String subject) { }
