package com.hashcorp.core.entity.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AuditableEntity extends AbstractEntity implements Serializable {

	private LocalDateTime created = LocalDateTime.now();
	private LocalDateTime updated = LocalDateTime.now();
	private LocalDateTime deleted = LocalDateTime.now();
}
