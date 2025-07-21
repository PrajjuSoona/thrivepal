package com.thrivepal.healthdata.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class HealthDataRequest {
	private String userEmail;
	private LocalDate date;
	private List<String> diet;
	private int sleepHours;
	private int waterIntake;
}
