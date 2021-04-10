package com.hashcorp.delivery.entity.domain.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class UserAuth extends org.springframework.security.core.userdetails.User {

	private final Long id;
	private final String shortNameEn;

	public UserAuth(final String username,
		final String password,
		final Collection<? extends GrantedAuthority> authorities,
		final Long id,
		final String shortNameEn) {
		super(username, password, authorities);
		this.id = id;
		this.shortNameEn = shortNameEn;
	}
}
