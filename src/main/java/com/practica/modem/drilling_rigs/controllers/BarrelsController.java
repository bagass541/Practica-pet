package com.practica.modem.drilling_rigs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.practica.modem.drilling_rigs.data.BarrelRepository;
import com.practica.modem.drilling_rigs.data.BoreholeBarrelRepository;
import com.practica.modem.drilling_rigs.data.BoreholeRepository;
import com.practica.modem.drilling_rigs.entity.Barrel;
import com.practica.modem.drilling_rigs.entity.Borehole;
import com.practica.modem.drilling_rigs.entity.BoreholeBarrel;

@Controller
@SessionAttributes("borehole_id")
public class BarrelsController {

	@Autowired
	private BoreholeRepository boreholeRepo;
	
	@Autowired
	private BarrelRepository barrelRepository;
	
	@Autowired
	private BoreholeBarrelRepository boreholeBarrelRepository;
	
	@GetMapping("borehole_details")
	public String showDetails(@RequestParam("borehole_id") Long idBorehole, Model model)
	{
		List<Barrel> barells = boreholeRepo.findById(idBorehole).get().getBarrels();
		model.addAttribute("barrels", barells);
		model.addAttribute("borehole_id", idBorehole);
		
		model.addAttribute("barrelForAdd", new Barrel());
		
		return "borehole_details";
	}
	
	@PostMapping("deleteBarrel")
	public String deleteBarrel(@RequestParam("barrel_id") Long idBarrel, Model model)
	{
		boreholeBarrelRepository.deleteAll(boreholeBarrelRepository.findByIdBarrel(idBarrel));
		barrelRepository.deleteById(idBarrel);
		
		return "redirect:/borehole_details" + "?borehole_id=" + model.getAttribute("borehole_id");
	}
	
	@PostMapping("addBarrel")
	public String addBarrel(@ModelAttribute Barrel barrel, Model model)
	{
		Long idBorehole = (Long) model.getAttribute("borehole_id");
		
		barrelRepository.save(barrel);
		boreholeBarrelRepository.save(new BoreholeBarrel(barrel.getId(), idBorehole));
		
		
		return "redirect:/borehole_details" + "?borehole_id=" + idBorehole;
	}
}
