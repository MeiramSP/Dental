package kz.saparov.dental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.dental.entity.Tooth;
import kz.saparov.dental.exception.PatientNotFoundException;
import kz.saparov.dental.service.ToothService;

@RestController
@RequestMapping("/teeth")
public class ToothController {
	
	private ToothService toothService;

	public ToothController(ToothService toothService) {
		this.toothService = toothService;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> saveTooth(@PathVariable Long id, @RequestBody Tooth tooth) {
		try {
			toothService.addTooth(id, tooth);
			return ResponseEntity.ok("Данные сохранены");
		} catch (PatientNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
