package com.example.market_service.repositories;


import com.example.market_service.domain.entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
    List<OrdersEntity> findByArtistid(Long artistId);
    List<OrdersEntity> findByClientid(Long clientID);
}
