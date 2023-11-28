package com.upc.demo_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/demo")
public class DemoDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDockerApplication.class, args);
	}

	@GetMapping("/greet/{name}")
	public String greeting(@PathVariable String name) {
		return "Hello, " + name;
	}

	@GetMapping("/status")
	public ResponseEntity<String> checkStatus() {
		return ResponseEntity.ok("Hello, WilverAR");
	}
}
