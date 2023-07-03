package com.practica.modem.drilling_rigs.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BushBoreholesId implements Serializable {
	

	private Long idBush;
	
	private Long idBorehole;

	public BushBoreholesId(Long idBush, Long idBorehole) {
		this.idBush = idBush;
		this.idBorehole = idBorehole;
	}
	
	
}
