package com.practica.modem.drilling_rigs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TypeDrilling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
}
