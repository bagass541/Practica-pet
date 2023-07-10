package com.practica.modem.drilling_rigs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practica.modem.drilling_rigs.entity.Barrel;
import com.practica.modem.drilling_rigs.entity.Borehole;

public interface BarrelRepository extends JpaRepository<Barrel, Long>{
	List<Barrel> findByBorehole(Borehole borehole);
	
	@Query(value = "SELECT * FROM barrel where id_borehole = :idBorehole and name = :bname", nativeQuery = true)
	List<Barrel> findByBoreholeName(@Param("idBorehole") Long idBorehole , @Param("bname") String bname);
}
