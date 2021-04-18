package com.hashcorp.delivery.domain.order.model;

public enum OrderStatus {
	NEW,
	WAITING_FOR_PAYMENT,
	PROCESSING,
	DELIVERING,
	DELIVERED,
	COMPLETED,
	CANCELLING,
	CANCELED,
	;
}
