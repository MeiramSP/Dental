package kz.saparov.dental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.service.PatientService;

@CrossOrigin("*")
@RestController
@RequestMapping("/patients")
public class PatientController {
	
	private PatientService patientService;

	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping
	public ResponseEntity<String> savePatient(@RequestBody Patient patient) {
		try {
			patientService.addPatient(patient);
			return ResponseEntity.ok("Пациент успешно добавлен");
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> findPatient(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(patientService.getPatient(id));
		} catch (PatientNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		try {
			patientService.updatePatient(id, patient);
			return ResponseEntity.ok("Данные о пациенте успешно обновлены");
		} catch (PatientNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePatient(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(patientService.deletePatient(id));
		}  catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
	
}
