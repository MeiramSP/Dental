package kz.saparov.dental.dto.patient;

import java.time.LocalDate;

import kz.saparov.dental.entity.Patient;

public class PatientDto {
	private Long id;
	private String fullName;
	private String address;
	private LocalDate birthDate;
	
	public PatientDto(Patient patient) {
		this.id = patient.getId();
		this.fullName = patient.getLastName() + " "+patient.getName() + " "+ patient.getPatronymic();
		this.address = patient.getAddress();
		this.birthDate = patient.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getAddress() {
		return address;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
}