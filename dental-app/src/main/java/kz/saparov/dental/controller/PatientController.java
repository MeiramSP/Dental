package kz.saparov.dental.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.dental.dto.patient.PatientDto;
import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.service.PatientService;

@CrossOrigin("*")
@RestController
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping("/patients")
	@PreAuthorize("hasAnyAuthority('patients:write')")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);	
	}
	
	@GetMapping("/patients") 
	@PreAuthorize("hasAnyAuthority('patients:read')")
	public List<PatientDto> searchPatient(@RequestParam String param) {
		return patientService.searchPatient(param);
	}
	
	@GetMapping("/patients/{id}")
	@PreAuthorize("hasAnyAuthority('patients:read')")
	public PatientDto findPatient(@PathVariable Long id) {
		return patientService.getPatient(id);
	}
	
	@PutMapping("/patients/{id}")
	@PreAuthorize("hasAnyAuthority('patients:write')")
	public String updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		patientService.updatePatient(id, patient);
		return "Данные успешно обновлены";
	}
	
	@DeleteMapping("/patients/{id}")
	@PreAuthorize("hasAnyAuthority('patients:write')")
	public String deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
		return "Пациент успешно удален";
	}
}