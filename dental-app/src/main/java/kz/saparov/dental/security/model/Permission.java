package kz.saparov.dental.security.model;

public enum Permission {
	
	PATIENTS_READ("patients:read"),
	PATIENTS_WRITE("patients:write");
	
	private final String permission;

	private Permission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
