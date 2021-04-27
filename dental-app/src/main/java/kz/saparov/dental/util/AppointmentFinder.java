package kz.saparov.dental.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentFinder {
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public AppointmentFinder() {}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		startDate += " 00:00";
		this.startDate = LocalDateTime.parse(startDate, this.formatter);
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		endDate += " 23:59";
		this.endDate = LocalDateTime.parse(endDate, this.formatter);
	}
}
