package kz.saparov.dental.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.dental.entity.Appointment;
import kz.saparov.dental.service.AppointmentService;
import kz.saparov.dental.util.AppointmentFinder;

@RestController
public class AppointmentController {
	
	private AppointmentService appointmentService;
	
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/appointments/{id}")
	public String saveAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		appointmentService.addAppointment(id, appointment);
		return "Запись на прием добавлена";
	}
	
	@PostMapping("/appointments")
	public List<Appointment> findRecords(@RequestBody AppointmentFinder finder) {
		return appointmentService.findByPeriod(finder);
	}
}
