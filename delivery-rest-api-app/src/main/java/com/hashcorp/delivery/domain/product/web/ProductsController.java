package com.hashcorp.delivery.domain.product.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hashcorp.delivery.commons.constants.ApiConstants;
import com.hashcorp.delivery.domain.product.infrastructure.ProductService;
import com.hashcorp.delivery.domain.product.web.dto.ProductDto;
import com.hashcorp.delivery.support.Try;

import lombok.RequiredArgsConstructor;

@RequestMapping("/" + ApiConstants.API_VERSION + "/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {

	private final ProductService productService;

	@GetMapping("/top")
	public ResponseEntity<List<ProductDto>> getTopSixProducts() {
		return Try.of(productService::getTopSixProducts)
			.map(p -> ResponseEntity.ok(productService.entitiesToDto(p)))
			.getOrElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		return Try.of(productService::getAllProducts)
			.map(p -> ResponseEntity.ok(productService.entitiesToDto(p)))
			.getOrElse(ResponseEntity.notFound().build());
	}

}
