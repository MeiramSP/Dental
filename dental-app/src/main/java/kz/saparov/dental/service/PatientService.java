package kz.saparov.dental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.repository.PatientRepository;

@Service
public class PatientService {
	
	private PatientRepository patientRepository;

	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	// find patient by id
	public Patient getPatient(Long id) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()->new PatientNotFoundException());
		return patient;
	}
	
	// save new patient
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	// update patient info
	public Patient updatePatient(Long id, Patient upPatient) {
		
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()->new PatientNotFoundException());
		
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
	
	public List<Patient> searchPatient (String search){
		return patientRepository.findByNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrPatronymicIgnoreCaseContaining(search, search, search);
		
	}
}
