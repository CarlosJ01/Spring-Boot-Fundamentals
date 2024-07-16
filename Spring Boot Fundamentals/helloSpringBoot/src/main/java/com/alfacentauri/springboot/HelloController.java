package com.alfacentauri.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Hacerlo un controlador de REST
public class HelloController {
	
	@RequestMapping("/hello") // Asigna una ruta
	public String hello() {
		return "Hello world Boot";
	}
	
}
