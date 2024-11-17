package com.ms.email.infra.repositories;

import com.ms.email.infra.entity.EmailEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, UUID>{}