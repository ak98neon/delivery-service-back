package com.hashcorp.delivery.domain.product.infrastructure;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.hashcorp.delivery.commons.db.AuditableEntity;
import com.hashcorp.delivery.domain.product.model.AvailableProduct;
import com.hashcorp.delivery.domain.product.model.Product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class ProductEntity extends AuditableEntity {

	private String name;
	private String description;
	@Column(name = "imgurl")
	private String imgUrl;

	public Product toDomain() {
		return new AvailableProduct(name, description, imgUrl);
	}

}
