package com.hashcorp.delivery.domain.product.infrastructure;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.hashcorp.delivery.entity.domain.AbstractEntity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity extends AbstractEntity {

	private String name;
	private String description;
	@Column(name = "imgurl")
	private String imgUrl;
}