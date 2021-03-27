package com.hashcorp.service;

import static com.hashcorp.dao.names.cache.CacheNames.*;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hashcorp.convertor.ProductConvertor;
import com.hashcorp.core.entity.domain.Product;
import com.hashcorp.core.entity.dto.ProductDto;
import com.hashcorp.dao.repository.ProductRepository;

@Service
public class ProductService extends AbstractService<Product, ProductRepository, Long> {

	private final ProductConvertor productConvertor;

	public ProductService(ProductRepository repository,
		ProductConvertor productConvertor) {

		super(repository);
		this.productConvertor = productConvertor;
	}

	@Cacheable(cacheNames = TOP_SIX_PRODUCTS)
	public List<ProductDto> getTopSixProducts() {
		final Page<Product> all = repository.findAll(PageRequest.of(0, 10));
		return entitiesToDto(all.getContent());
	}

	@Cacheable(cacheNames = ALL_PRODUCTS)
	public List<ProductDto> getAllProducts() {
		return entitiesToDto(repository.findAll());
	}

	public List<ProductDto> entitiesToDto(List<Product> products) {
		return products.stream()
			.map(productConvertor::convert)
			.collect(toList());
	}
}
