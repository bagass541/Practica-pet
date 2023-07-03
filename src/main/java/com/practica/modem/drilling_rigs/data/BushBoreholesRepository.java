package com.practica.modem.drilling_rigs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.modem.drilling_rigs.entity.BushBoreholes;
import com.practica.modem.drilling_rigs.entity.BushBoreholesId;

public interface BushBoreholesRepository extends JpaRepository<BushBoreholes, BushBoreholesId> {

	List<BushBoreholes> findByIdBorehole(Long idBorehole);
}
