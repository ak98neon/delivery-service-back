package com.hashcorp.delivery.domain.order.infrastructure;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hashcorp.delivery.domain.order.model.OrderStorage;
import com.hashcorp.delivery.domain.order.web.dto.OrderDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderDefaultStorage implements OrderStorage {

	private final OrderJpaRepository orderJpaRepository;
	private final OrderConvertor orderConvertor;

	@Override
	public List<OrderEntity> findAll() {
		return orderJpaRepository.findAll();
	}

	@Override
	public List<OrderDto> entitiesToDto(List<OrderEntity> orderEntities) {
		return orderEntities.stream()
			.map(this::toDTO)
			.collect(toList());
	}

	@Override
	public OrderDto toDTO(OrderEntity orderEntity) {
		return orderConvertor.convert(orderEntity);
	}
}
