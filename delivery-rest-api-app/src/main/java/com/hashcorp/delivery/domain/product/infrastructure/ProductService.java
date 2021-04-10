package com.hashcorp.delivery.domain.product.infrastructure;

import static com.hashcorp.delivery.config.names.cache.CacheNames.*;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hashcorp.delivery.commons.convertor.ProductConvertor;
import com.hashcorp.delivery.domain.product.web.dto.ProductDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private final ProductConvertor productConvertor;
	private final ProductJpaRepository repository;

	@Cacheable(cacheNames = TOP_SIX_PRODUCTS)
	public List<ProductEntity> getTopSixProducts() {
		return repository.findAll(PageRequest.of(0, 10)).getContent();
	}

	@Cacheable(cacheNames = ALL_PRODUCTS)
	public List<ProductEntity> getAllProducts() {
		return repository.findAll();
	}

	public ProductDto toDTO(ProductEntity productEntity) {
		return productConvertor.convert(productEntity);
	}

	public List<ProductDto> entitiesToDto(List<ProductEntity> productEntities) {
		return productEntities.stream()
			.map(this::toDTO)
			.collect(toList());
	}
}
