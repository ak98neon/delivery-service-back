package com.hashcorp.delivery.web;

import static com.hashcorp.delivery.constants.ApiConstants.API_VERSION;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hashcorp.delivery.dto.ProductDto;

import lombok.RequiredArgsConstructor;

@RequestMapping("/" + API_VERSION + "/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {

	@GetMapping
	public List<ProductDto> getProducts() {
		return List.of(new ProductDto("testProductName"));
	}
}
