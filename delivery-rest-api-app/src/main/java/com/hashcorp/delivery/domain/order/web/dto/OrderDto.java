package com.hashcorp.delivery.domain.order.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.hashcorp.delivery.domain.order.model.OrderStatus;
import com.hashcorp.delivery.domain.product.model.Product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private Set<Product> products;
	private BigDecimal totalPrice;
	private int quantity;
	private OrderStatus status;
	private LocalDateTime created;
	private LocalDateTime updated;
	private LocalDateTime deleted;
}
