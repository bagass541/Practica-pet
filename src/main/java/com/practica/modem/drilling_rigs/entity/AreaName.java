package com.practica.modem.drilling_rigs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "area")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AreaName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
}
