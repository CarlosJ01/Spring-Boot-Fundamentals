package com.alfacentauri.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class vaccinWebController {
	
	@Autowired
	private VaccineService service;
	
	@GetMapping("/")
	public Mono<String> getVaccines(Model model) {
		model.addAttribute("vacciones", service.getVaccines());
		return Mono.just("index");
	}
}
