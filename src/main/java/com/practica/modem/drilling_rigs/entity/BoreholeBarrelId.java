package com.practica.modem.drilling_rigs.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BoreholeBarrelId implements Serializable{

	private long idBorehole;
	
	private long idBarrel;

	public BoreholeBarrelId(long idBorehole, long idBarrel) {
		this.idBorehole = idBorehole;
		this.idBarrel = idBarrel;
	}
	
	
}
