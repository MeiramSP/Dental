package kz.saparov.dental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.dental.entity.Appointment;
import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.repository.AppointmentRepository;
import kz.saparov.dental.repository.PatientRepository;
import kz.saparov.dental.util.AppointmentFinder;

@Service
public class AppointmentService {
	private AppointmentRepository appointmentRepository;
	private PatientRepository patientRepository;

	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
		this.appointmentRepository = appointmentRepository;
		this.patientRepository = patientRepository;
	}
	
	public Appointment addAppointment(Long id, Appointment appointment) {
		
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()-> new PatientNotFoundException());
		appointment.setPatient(patient);
		
		return appointmentRepository.save(appointment);
	}
	
	public List<Appointment> findByPeriod(AppointmentFinder finder){
		List<Appointment> appointments = new ArrayList<>();
		appointments = appointmentRepository.findByDateTimeBetween(finder.getStartDate(), finder.getEndDate());
		return appointments;
	}
}
