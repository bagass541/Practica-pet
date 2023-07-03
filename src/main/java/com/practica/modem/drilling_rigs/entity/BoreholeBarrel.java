package com.practica.modem.drilling_rigs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "borehole_barrels")
@IdClass(BoreholeBarrelId.class)
public class BoreholeBarrel {


	
	@Id
	@Column(name = "borehole_id")
	private long idBorehole;
	
	@Id
	@Column(name = "barrels_id")
	private long idBarrel;
}
