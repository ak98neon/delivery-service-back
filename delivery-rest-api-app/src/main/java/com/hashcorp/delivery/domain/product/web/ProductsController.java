package com.hashcorp.delivery.domain.product.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hashcorp.delivery.commons.constants.ApiConstants;
import com.hashcorp.delivery.domain.product.model.ProductStorage;
import com.hashcorp.delivery.domain.product.web.dto.ProductDto;
import com.hashcorp.delivery.support.Try;

import lombok.RequiredArgsConstructor;

@RequestMapping("/" + ApiConstants.API_VERSION + "/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {

	private final ProductStorage products;

	@GetMapping("/top")
	public ResponseEntity<List<ProductDto>> getTopSixProducts() {
		return Try.of(products::getTopSixProducts)
			.map(p -> ResponseEntity.ok(products.entitiesToDto(p)))
			.getOrElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		return Try.of(products::getAllProducts)
			.map(p -> ResponseEntity.ok(products.entitiesToDto(p)))
			.getOrElse(ResponseEntity.notFound().build());
	}

}
