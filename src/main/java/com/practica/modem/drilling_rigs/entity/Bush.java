package com.practica.modem.drilling_rigs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "bush")
@NoArgsConstructor
public class Bush {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_area")
	private AreaName areaName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Borehole> boreholes;
}
