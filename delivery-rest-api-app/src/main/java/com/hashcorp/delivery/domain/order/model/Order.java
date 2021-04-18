package com.hashcorp.delivery.domain.order.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.hashcorp.delivery.domain.product.model.Product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements IOrder {

	private Set<Product> products;
	private BigDecimal totalPrice;
	private int quantity;
	private OrderStatus status;
	private LocalDateTime created;

	@Override
	public Set<Product> products() {
		return products;
	}

	@Override
	public BigDecimal totalPrice() {
		return totalPrice;
	}

	@Override
	public int quantity() {
		return quantity;
	}

	@Override
	public OrderStatus status() {
		return status;
	}

	public Order newOrder() {
		return new Order();
	}
}
