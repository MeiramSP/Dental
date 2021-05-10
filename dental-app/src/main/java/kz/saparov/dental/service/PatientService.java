package kz.saparov.dental.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kz.saparov.dental.dto.patient.PatientDto;
import kz.saparov.dental.dto.patient.PatientWithTeethDto;
import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.repository.PatientRepository;

@Service
public class PatientService {
	
	private PatientRepository patientRepository;

	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public PatientDto getPatient(Long id) {
		return new PatientWithTeethDto(patientRepository.findPatientbyId(id)
			.orElseThrow(()->new PatientNotFoundException()));
	}
	
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Patient updatePatient(Long id, Patient upPatient) {
		return patientRepository.findById(id).map(patient->{
				patient.setName(upPatient.getName());
				patient.setLastName(upPatient.getLastName());
				patient.setPatronymic(upPatient.getPatronymic());
				patient.setAddress(upPatient.getAddress());
				patient.setBirthDate(upPatient.getBirthDate());
				return patientRepository.save(patient);})
			.orElseThrow(()->new PatientNotFoundException());
	}
	
	public Long deletePatient(Long id) {
		patientRepository.deleteById(id);
		return id;
	}
	
	public List<PatientDto> searchPatient (String param){
		if(!param.isEmpty()) {
			param.trim();
			
			List<Patient> patients = patientRepository.findByNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrPatronymicIgnoreCaseContaining(param, param, param);
			
			if(!patients.isEmpty())
				return patients.stream()
					.map(patient -> new PatientDto(patient))
					.collect(Collectors.toList());
		}	
		return null;
	}
}
