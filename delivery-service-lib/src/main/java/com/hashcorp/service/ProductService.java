package com.hashcorp.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

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

	public List<ProductDto> getTopSixProducts() {
		final Page<Product> all = repository.findAll(PageRequest.of(0, 10));
		return entitiesToDto(all.getContent());
	}

	public List<ProductDto> getAllProducts() {
		return entitiesToDto(repository.findAll());
	}

	public List<ProductDto> entitiesToDto(List<Product> products) {
		return products.stream()
			.map(productConvertor::convert)
			.collect(toList());
	}
}
