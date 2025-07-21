package com.thrivepal.healthdata.service;

import com.thrivepal.healthdata.model.HealthData;
import com.thrivepal.healthdata.repository.HealthDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthDataService {
	private final HealthDataRepository repository;

	public HealthData saveHealthData(HealthData data) {
		return repository.save(data);
	}

	public List<HealthData> getHealthDataByUser(String email) {
		return repository.findByUserEmail(email);
	}

	public List<HealthData> getHealthDataByUserAndDateRange(String email, LocalDate start, LocalDate end) {
		return repository.findByUserEmailAndDateBetween(email, start, end);
	}
}
