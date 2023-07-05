package com.practica.modem.drilling_rigs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practica.modem.drilling_rigs.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Long>{

	@Query(value = "SELECT * FROM area where name = :aName", nativeQuery = true)
	List<Area> findByAName(@Param("aName") String aName);
}
