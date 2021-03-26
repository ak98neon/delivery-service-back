package com.hashcorp.delivery.web;

import static com.hashcorp.delivery.constants.ApiConstants.API_VERSION;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hashcorp.core.entity.dto.ProductDto;
import com.hashcorp.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/" + API_VERSION + "/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {

	private final ProductService productService;

	@GetMapping
	public List<ProductDto> getTopSixProducts() {
		return productService.getTopSixProducts();
	}
}
