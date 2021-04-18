package com.hashcorp.delivery.domain.order.web.dto;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewOrderDto {

	private List<String> productIds;
	private int count;
}
