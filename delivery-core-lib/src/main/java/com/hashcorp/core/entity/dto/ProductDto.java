package com.hashcorp.core.entity.dto;

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
