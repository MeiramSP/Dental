package kz.saparov.dental.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AppointmentStatus {
	@JsonProperty("активен")
	ACTIVE,
	@JsonProperty("завершен")
	COMPLETED,
	@JsonProperty("отменен")
	CANCELED
}
