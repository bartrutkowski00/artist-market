package com.am.user_service.repositories;

import com.am.user_service.domain.entities.UserroleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserroleRepository extends JpaRepository<UserroleEntity, Long> {
}
