package com.practica.modem.drilling_rigs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.modem.drilling_rigs.entity.BoreholeBarrel;
import com.practica.modem.drilling_rigs.entity.BoreholeBarrelId;
import com.practica.modem.drilling_rigs.entity.BushBoreholes;

public interface BoreholeBarrelRepository extends JpaRepository<BoreholeBarrel, BoreholeBarrelId>{

	List<BoreholeBarrel> findByIdBorehole(Long idBorehole);
	
	List<BoreholeBarrel> findByIdBarrel(Long idBarrel);
}
