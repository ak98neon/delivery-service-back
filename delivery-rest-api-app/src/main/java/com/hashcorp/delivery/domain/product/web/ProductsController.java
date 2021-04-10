package com.hashcorp.delivery.domain.product.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hashcorp.core.entity.dto.ProductDto;
import com.hashcorp.delivery.commons.constants.ApiConstants;
import com.hashcorp.delivery.domain.product.infrastructure.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/" + ApiConstants.API_VERSION + "/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {

	private final ProductService productService;

	@GetMapping("/top")
	public List<ProductDto> getTopSixProducts() {
		return productService.getTopSixProducts();
	}

	@GetMapping("/")
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();
	}

}
