package com.hashcorp.core.entity.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

	private String name;
	private String description;
	private String imgUrl;
}
