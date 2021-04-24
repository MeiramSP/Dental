package kz.saparov.dental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.dental.entity.Appointment;
import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.repository.AppointmentRepository;
import kz.saparov.dental.repository.PatientRepository;

@Service
public class AppointmentService {
	private AppointmentRepository appointmentRepository;
	private PatientRepository patientRepository;

	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
		this.appointmentRepository = appointmentRepository;
		this.patientRepository = patientRepository;
	}
	
	public Appointment addAppointment(Long id, Appointment appointment) throws PatientNotFoundException {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()-> new PatientNotFoundException("Пациент с id " + id + " не найден"));
		appointment.setPatient(patient);
		
		return appointmentRepository.save(appointment);
	}

	
	
	

}
