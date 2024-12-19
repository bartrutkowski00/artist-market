package com.am.user_service.repositories;

import com.am.user_service.domain.entities.UsrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsrRepository extends JpaRepository<UsrEntity, Long> {

    List<UsrEntity> findByUsername(String username);
    Optional<UsrEntity> findByUsernameAndPassword(String username, String password);
}
