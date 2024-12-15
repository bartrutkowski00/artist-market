package com.am.user_service.repositories;

import domain.entities.UsrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepository extends JpaRepository<UsrEntity, Long> {
}
