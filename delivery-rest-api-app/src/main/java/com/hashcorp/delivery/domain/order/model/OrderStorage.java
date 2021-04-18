package com.hashcorp.delivery.domain.order.model;

import java.util.List;

import com.hashcorp.delivery.domain.order.infrastructure.OrderEntity;
import com.hashcorp.delivery.domain.order.web.dto.OrderDto;

public interface OrderStorage {

	List<OrderEntity> findAll();

	List<OrderDto> entitiesToDto(List<OrderEntity> orderEntities);

	OrderDto toDTO(OrderEntity orderEntity);
}
