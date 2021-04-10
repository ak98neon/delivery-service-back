package com.hashcorp.delivery.domain.client.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.hashcorp.delivery.commons.db.AbstractEntity;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -5166607363742144484L;

	@Enumerated(value = EnumType.STRING)
	@Column(updatable = false, unique = true)
	private RoleName name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "permission_role", joinColumns = {
		@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
		@JoinColumn(name = "permission_id", referencedColumnName = "id")})
	private Set<Permission> permissions = new HashSet<>();
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
}
