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
	
	@PostMapping("/teeth/{id}")
	public String saveTooth(@PathVariable Long id, @RequestBody Tooth tooth) {
		toothService.addTooth(id, tooth);
		return "Данные обновлены";
			
	}
	
}
