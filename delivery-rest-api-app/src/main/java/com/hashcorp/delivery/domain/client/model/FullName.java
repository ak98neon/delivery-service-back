package com.hashcorp.delivery.entity.domain.user;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class FullName implements Serializable {

	private static final long serialVersionUID = -8821821505258411371L;

	private String firstName;
	private String middleName;
	private String lastName;
}
