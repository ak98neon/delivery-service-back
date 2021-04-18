package com.hashcorp.delivery.domain.order.model;

import java.math.BigDecimal;
import java.util.Set;

import com.hashcorp.delivery.domain.product.model.Product;

public interface IOrder {

	Set<Product> products();

	BigDecimal totalPrice();

	int quantity();

	OrderStatus status();
}
