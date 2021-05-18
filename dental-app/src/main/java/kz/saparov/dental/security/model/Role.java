package kz.saparov.dental.security.model;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
	DOCTOR(Set.of(Permission.PATIENTS_READ)),
	
	ADMIN(Set.of(Permission.PATIENTS_READ, 
			     Permission.PATIENTS_WRITE));
	
	private final Set<Permission> permissions;

	private Role(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getAuthorities() {
		return getPermissions().stream()
				.map(permission-> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
	}
}
