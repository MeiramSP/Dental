package kz.saparov.dental.dto.patient;

import java.util.Set;

import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.entity.Tooth;

public class PatientWithTeethDto extends PatientDto {
	
	private Set<Tooth> teeth;

	public PatientWithTeethDto(Patient patient) {
		super(patient);
		this.teeth = patient.getTeeth();
	}

	public Set<Tooth> getTeeth() {
		return teeth;
	}
}

