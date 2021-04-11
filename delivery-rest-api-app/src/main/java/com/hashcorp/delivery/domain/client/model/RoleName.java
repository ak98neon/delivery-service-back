package com.hashcorp.delivery.domain.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleName {
	ROLE_ADMIN("Admin"),
	ROLE_USER("User"),
	;

	private final String humanReadableName;
}
