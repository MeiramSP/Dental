package kz.saparov.dental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.dental.entity.Appointment;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> saveAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		try {
			appointmentService.addAppointment(id, appointment);
			return ResponseEntity.ok("Запись на прием добавлена");
		} catch (PatientNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
