package com.hashcorp.delivery.entity.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
}
