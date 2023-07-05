package com.practica.modem.drilling_rigs.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "borehole", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name", "id_bush"})
})
@NoArgsConstructor
@Data
public class Borehole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Pattern(regexp = "СКВ-#\\d+",
	message = "Имя должно быть вида СКВ-#(число)")
	private String name;
	
	
	@Column(name = "begin_date")
	private LocalDate beginDate;
	

	@Column(name = "end_date")
	private LocalDate endDate;
	
	@NotNull
	private float x;
	
	@NotNull
	private float y;
	
	@ManyToOne
	@JoinColumn(name = "id_bush")
	private Bush bush;
	
	@OneToOne
	@JoinColumn(name = "id_type_drill")
	@NotNull
	private TypeDrilling typeDrilling;
	
	@OneToMany
	private List<Barrel> barrels;
	
	
	public boolean hasNeighbours()
	{
		if(bush != null && bush.getBoreholes().size() > 1)
		{
			return true;
		}
		return false;
	}
	
	public boolean hasSeveralBarrels()
	{
		if(barrels.size() > 1)
		{
			return true;
		}
		return false;
	}
	
}
