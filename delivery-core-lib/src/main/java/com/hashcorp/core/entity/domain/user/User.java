package com.hashcorp.core.entity.domain.user;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hashcorp.core.entity.domain.AuditableEntity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "users")
@Data
public class User extends AuditableEntity implements UserDetails, Serializable {

	private static final long serialVersionUID = -2345803969883326081L;

	@Column(unique = true)
	private String username;
	@JsonIgnore
	private String password;
	private String email;
	private boolean enabled = true;
	@Column(name = "account_non_locked")
	private boolean accountNonLocked = true;
	@Column(name = "account_expired")
	private boolean accountNonExpired = true;
	@Column(name = "credentials_expired")
	private boolean credentialsNonExpired = true;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "role_users", joinColumns = {
		@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
		@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private Set<Role> roles = new HashSet<>();

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final Set<GrantedAuthority> authorities = new HashSet<>();
		roles.forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getName().name()));
			r.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getName())));
		});

		return authorities;
	}
}
