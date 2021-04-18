package com.hashcorp.delivery.domain.order.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashcorp.delivery.domain.order.model.OrderRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long>, OrderRepository {

}
