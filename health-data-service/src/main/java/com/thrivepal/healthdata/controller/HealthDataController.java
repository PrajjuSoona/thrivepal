package com.thrivepal.healthdata.controller;

import com.thrivepal.healthdata.model.HealthData;
import com.thrivepal.healthdata.service.HealthDataService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/health")
@RequiredArgsConstructor
public class HealthDataController {

	private final HealthDataService service;

	@PostMapping
	public HealthData submitHealthData(HttpServletRequest request, @RequestBody HealthData data) {
		String email = (String) request.getAttribute("userEmail");
		data.setUserEmail(email);
		return service.saveHealthData(data);
	}

	@GetMapping("/{email}")
	public List<HealthData> getByUser(HttpServletRequest request) {
		String email = (String) request.getAttribute("userEmail");
		return service.getHealthDataByUser(email);	}

	@GetMapping("/{email}/range")
	public List<HealthData> getByUserAndRange(
			HttpServletRequest request,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
	) {
		String email = (String) request.getAttribute("userEmail");
		return service.getHealthDataByUserAndDateRange(email, start, end);	}
}
