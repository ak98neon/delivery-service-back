package com.hashcorp.delivery.domain.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvailableProduct implements Product {

	private String name;
	private String description;
	private String imgUrl;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getImgUrl() {
		return imgUrl;
	}
}
