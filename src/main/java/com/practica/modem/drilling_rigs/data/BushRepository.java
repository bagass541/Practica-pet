package com.practica.modem.drilling_rigs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.modem.drilling_rigs.entity.Bush;

public interface BushRepository extends JpaRepository<Bush, Long>{

	List<Bush> findByName(String name);
}
