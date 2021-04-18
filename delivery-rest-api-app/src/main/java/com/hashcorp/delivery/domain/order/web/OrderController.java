package com.hashcorp.delivery.domain.order.web;

import static com.hashcorp.delivery.commons.constants.ApiConstants.API_VERSION;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hashcorp.delivery.domain.order.model.OrderStorage;
import com.hashcorp.delivery.domain.order.web.dto.CreateNewOrderDto;
import com.hashcorp.delivery.domain.order.web.dto.OrderDto;
import com.hashcorp.delivery.support.Try;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/" + API_VERSION + "/orders")
@RestController
public class OrderController {

	private final OrderStorage orders;

	@PostMapping
	public ResponseEntity<OrderDto> createNewOrder(CreateNewOrderDto createNewOrderDto) {
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<OrderDto>> getAllOrders() {
		return Try.of(orders::findAll)
			.map(o -> ResponseEntity.ok(orders.entitiesToDto(o)))
			.getOrElse(ResponseEntity.notFound().build());
	}
}
