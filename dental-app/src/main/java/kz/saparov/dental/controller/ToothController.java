package kz.saparov.dental.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.dental.entity.Tooth;
import kz.saparov.dental.service.ToothService;

@RestController
public class ToothController {
	
	private ToothService toothService;
	
	public ToothController(ToothService toothService) {
		this.toothService = toothService;
	}
	
	@PostMapping("/patients/{id}/teeth")
	public Tooth saveTooth(@PathVariable Long id, @RequestBody Tooth tooth) {
		return toothService.saveOrUpdateTooth(id, tooth);
	}
}

