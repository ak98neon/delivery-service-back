package com.hashcorp.delivery.domain.order.model;

import java.util.List;

import com.hashcorp.delivery.domain.order.infrastructure.OrderEntity;

public interface OrderRepository {

	List<OrderEntity> findAll();
}
