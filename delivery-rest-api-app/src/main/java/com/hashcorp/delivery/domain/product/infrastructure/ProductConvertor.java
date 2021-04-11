package com.hashcorp.delivery.domain.product.infrastructure;

import org.springframework.stereotype.Service;

import com.hashcorp.delivery.commons.convertor.abstraction.AbstractSimpleEntityConverter;
import com.hashcorp.delivery.commons.convertor.abstraction.ModelMapperService;
import com.hashcorp.delivery.domain.product.web.dto.ProductDto;

@Service
public class ProductConvertor extends AbstractSimpleEntityConverter<ProductEntity, ProductDto> {

	public ProductConvertor(ModelMapperService modelMapperService) {
		super(modelMapperService);
	}

	@Override
	protected Class<ProductEntity> getEntityClass() {
		return ProductEntity.class;
	}

	@Override
	protected Class<ProductDto> getDtoClass() {
		return ProductDto.class;
	}
}