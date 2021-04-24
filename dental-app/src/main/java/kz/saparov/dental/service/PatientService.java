package kz.saparov.dental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.repository.PatientRepository;

@Service
public class PatientService {
	
	private PatientRepository patientRepository;

	@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	// find patient by id
	public Patient getPatient(Long id) throws PatientNotFoundException {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()->new PatientNotFoundException("Пациент с id " + id + " не найден"));
		
		return patient;
	}
	
	// save new patient
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	// update patient info
	public Patient updatePatient(Long id, Patient upPatient) throws PatientNotFoundException {
		
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()->new PatientNotFoundException("Пациент с id " + id + " не найден"));
		
		patient.setName(upPatient.getName());
		patient.setLastName(upPatient.getLastName());
		patient.setPatronymic(upPatient.getPatronymic());
		patient.setAddress(upPatient.getAddress());
		patient.setBirthDate(upPatient.getBirthDate());
		
		return patientRepository.save(patient);
	}
	
	
	public Long deletePatient(Long id) {
		patientRepository.deleteById(id);
		return id;
	}
}
