package com.thrivepal.healthdata.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thrivepal.healthdata.model.HealthData;

public interface HealthDataRepository extends JpaRepository<HealthData, Long> {
	List<HealthData> findByUserEmail(String userEmail);
	List<HealthData> findByUserEmailAndDateBetween(String userEmail, LocalDate start, LocalDate end);

}
