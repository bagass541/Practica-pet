package com.practica.modem.drilling_rigs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull
	@Column(unique = true)
	private String name;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_area")
	@NotNull
	private Area area;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bush")
	private List<Borehole> boreholes;
}
