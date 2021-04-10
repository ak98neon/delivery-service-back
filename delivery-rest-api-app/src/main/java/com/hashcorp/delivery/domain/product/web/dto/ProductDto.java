package com.hashcorp.delivery.domain.product.web.dto;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto implements Serializable {

	private String name;
	private String description;
	private String imgUrl;
}
