package com.thrivepal.healthdata.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userEmail;

	private LocalDate date;

	@ElementCollection
	@CollectionTable(name = "diet_items", joinColumns = @JoinColumn(name = "health_data_id"))
	@Column(name = "item")
	private List<String> diet;

	private double sleepHours;

	private double waterIntake;
}


