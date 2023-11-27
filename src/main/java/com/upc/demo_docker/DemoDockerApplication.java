package com.upc.demo_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class DemoDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDockerApplication.class, args);
	}

	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getJVMInfo() {
		Runtime runtime = Runtime.getRuntime();
		File cDrive = new File("C:");

		Map<String, Object> info = new HashMap<>();
		info.put("CPUS", runtime.availableProcessors());
		info.put("MemoriaMaxima", runtime.maxMemory() / 1024 / 1024);
		info.put("MemoriaTotal", runtime.totalMemory() / 1024 / 1024);
		info.put("MemoriaLibre", runtime.freeMemory() / 1024 / 1024);

		double elapseTime = (double) (System.nanoTime() - System.nanoTime()) / 1_000_000_000;
		info.put("TiempoSec", elapseTime);

		info.put("EspacioTotalC", String.format("%.2f GB", (double) cDrive.getTotalSpace() / 1073741824));
		info.put("EspacioLibreC", String.format("%.2f GB", (double) cDrive.getFreeSpace() / 1073741824));

		return ResponseEntity.ok(info);
	}
}
