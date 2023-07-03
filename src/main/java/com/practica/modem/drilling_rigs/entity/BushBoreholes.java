package com.practica.modem.drilling_rigs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
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
@Table(name ="bush_boreholes")
@IdClass(BushBoreholesId.class)
public class BushBoreholes {
	
	@Id
	@Column(name = "bush_id")
	private Long idBush;
	
	@Id
	@Column(name = "boreholes_id")
	private Long idBorehole;
}
