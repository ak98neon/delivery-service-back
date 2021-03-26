package com.hashcorp.convertor;

import org.springframework.stereotype.Service;

import com.hashcorp.convertor.abstraction.AbstractSimpleEntityConverter;
import com.hashcorp.convertor.abstraction.ModelMapperService;
import com.hashcorp.core.entity.domain.Product;
import com.hashcorp.core.entity.dto.ProductDto;

@Service
public class ProductConvertor extends AbstractSimpleEntityConverter<Product, ProductDto> {

	public ProductConvertor(ModelMapperService modelMapperService) {
		super(modelMapperService);
	}

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

	@Override
	protected Class<ProductDto> getDtoClass() {
		return ProductDto.class;
	}
}
