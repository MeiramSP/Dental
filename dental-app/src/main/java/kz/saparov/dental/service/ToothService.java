package kz.saparov.dental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.entity.Tooth;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.repository.PatientRepository;
import kz.saparov.dental.repository.ToothRepository;

@Service
public class ToothService {

	private ToothRepository toothRepository;
	private PatientRepository patientRepository;

	@Autowired
	public ToothService(ToothRepository toothRepository, PatientRepository patientRepository) {
		this.toothRepository = toothRepository;
		this.patientRepository = patientRepository;
	}

	public Tooth addTooth(Long id, Tooth tooth) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()-> new PatientNotFoundException());
		tooth.setPatient(patient);
		
		return toothRepository.save(tooth);
	}
	
}
