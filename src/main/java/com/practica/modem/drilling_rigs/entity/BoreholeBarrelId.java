package com.practica.modem.drilling_rigs.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BoreholeBarrelId implements Serializable{
	
	private long idBarrel;

	private long idBorehole;
	
	public BoreholeBarrelId(long idBorehole, long idBarrel) {
		this.idBorehole = idBorehole;
		this.idBarrel = idBarrel;
	}
	
	
}
