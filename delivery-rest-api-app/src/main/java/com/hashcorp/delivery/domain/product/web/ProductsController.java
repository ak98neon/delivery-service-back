package com.hashcorp.delivery.web;

import static com.hashcorp.delivery.commons.constants.ApiConstants.API_VERSION;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hashcorp.delivery.domain.product.web.dto.ProductDto;
import com.hashcorp.delivery.domain.product.infrastructure.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/" + API_VERSION + "/products")
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
