package com.practica.modem.drilling_rigs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.practica.modem.drilling_rigs.entity.Borehole;
import com.practica.modem.drilling_rigs.entity.Bush;


public interface BoreholeRepository extends JpaRepository<Borehole, Long>{
	
	List<Borehole> findByBush(Bush bush);
	
	
	
}
