package com.payment.payment_service.repositories;

import com.payment.payment_service.domain.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findAllByClientid(Long clientid);
}
