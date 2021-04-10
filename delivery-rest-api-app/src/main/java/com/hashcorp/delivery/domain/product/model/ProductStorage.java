package com.hashcorp.delivery.domain.product.model;

import java.util.List;

import com.hashcorp.delivery.domain.product.infrastructure.ProductEntity;
import com.hashcorp.delivery.domain.product.web.dto.ProductDto;

public interface ProductStorage {

	List<ProductEntity> getTopSixProducts();

	List<ProductEntity> getAllProducts();

	ProductDto toDTO(ProductEntity productEntity);

	List<ProductDto> entitiesToDto(List<ProductEntity> productEntities);
}
