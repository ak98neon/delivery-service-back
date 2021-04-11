package com.hashcorp.delivery.domain.product.infrastructure;

import static com.hashcorp.delivery.config.names.cache.CacheNames.*;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hashcorp.delivery.domain.product.model.ProductStorage;
import com.hashcorp.delivery.domain.product.web.dto.ProductDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductStorageDefault implements ProductStorage {

	private final ProductConvertor productConvertor;
	private final ProductJpaRepository repository;

	@Override
	@Cacheable(cacheNames = TOP_SIX_PRODUCTS)
	public List<ProductEntity> getTopSixProducts() {
		return repository.findAll(PageRequest.of(0, 10)).getContent();
	}

	@Override
	@Cacheable(cacheNames = ALL_PRODUCTS)
	public List<ProductEntity> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public ProductDto toDTO(ProductEntity productEntity) {
		return productConvertor.convert(productEntity);
	}

	@Override
	public List<ProductDto> entitiesToDto(List<ProductEntity> productEntities) {
		return productEntities.stream()
			.map(this::toDTO)
			.collect(toList());
	}
}
