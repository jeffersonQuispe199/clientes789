package com.krakedev.clientes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaConreoller {
	@GetMapping("/hola")
public String saludar() {
	return"hola desde Spring Boot";
}
}
