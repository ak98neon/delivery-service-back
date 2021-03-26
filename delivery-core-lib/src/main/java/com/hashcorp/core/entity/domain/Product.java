package com.hashcorp.core.entity.domain;

import javax.persistence.Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbstractEntity {

	private String name;
	private String description;
	private String imgUrl;
}
