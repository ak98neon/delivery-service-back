package com.hashcorp.delivery.domain.order.infrastructure;

import static java.util.stream.Collectors.toSet;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.*;

import com.hashcorp.delivery.commons.db.AuditableEntity;
import com.hashcorp.delivery.domain.order.model.Order;
import com.hashcorp.delivery.domain.order.model.OrderStatus;
import com.hashcorp.delivery.domain.product.infrastructure.ProductEntity;
import com.hashcorp.delivery.domain.product.model.Product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order")
public class OrderEntity extends AuditableEntity {

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProductEntity> products;
	private BigDecimal totalPrice;
	private int quantity;
	private OrderStatus status;

	public Order toDomain() {
		final Set<Product> productsDomain = products.stream()
			.map(ProductEntity::toDomain)
			.collect(toSet());
		return new Order(productsDomain, totalPrice, quantity, status, getCreated());
	}
}
