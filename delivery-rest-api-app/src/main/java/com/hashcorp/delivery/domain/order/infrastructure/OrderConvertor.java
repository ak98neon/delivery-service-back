package com.hashcorp.delivery.domain.order.infrastructure;

import org.springframework.stereotype.Service;

import com.hashcorp.delivery.commons.convertor.abstraction.AbstractSimpleEntityConverter;
import com.hashcorp.delivery.commons.convertor.abstraction.ModelMapperService;
import com.hashcorp.delivery.domain.order.web.dto.OrderDto;

@Service
public class OrderConvertor extends AbstractSimpleEntityConverter<OrderEntity, OrderDto> {

	public OrderConvertor(ModelMapperService modelMapperService) {
		super(modelMapperService);
	}

	@Override
	protected Class<OrderEntity> getEntityClass() {
		return OrderEntity.class;
	}

	@Override
	protected Class<OrderDto> getDtoClass() {
		return OrderDto.class;
	}
}
