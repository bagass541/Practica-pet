package com.practica.modem.drilling_rigs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.modem.drilling_rigs.data.BoreholeRepository;
import com.practica.modem.drilling_rigs.data.BushBoreholesRepository;
import com.practica.modem.drilling_rigs.data.BushRepository;
import com.practica.modem.drilling_rigs.data.TypeDrillingRepository;
import com.practica.modem.drilling_rigs.entity.Borehole;
import com.practica.modem.drilling_rigs.entity.Bush;
import com.practica.modem.drilling_rigs.entity.BushBoreholes;
import com.practica.modem.drilling_rigs.entity.TypeDrilling;

@Controller
@RequestMapping("/addNewBorehole")
public class AddBoreholeController {

	@Autowired
	private BoreholeRepository boreholeRepo;
	
	@Autowired
	private BushRepository bushRepository;
	
	@Autowired
	private TypeDrillingRepository typeDrillingRepository;
	
	@Autowired
	private BushBoreholesRepository bushBoreholesRepository;
	

	@GetMapping
	public String showAddNewBorehole(Model model) {
		
		Borehole borehole = new Borehole();
		model.addAttribute("borehole", borehole);
		model.addAttribute("bushes", bushRepository.findAll());
		model.addAttribute("types", typeDrillingRepository.findAll());
							
		return "addBorehole";
	}
	
	@PostMapping
	public String saveBorehole(@ModelAttribute("borehole") Borehole borehole) {
		
		boreholeRepo.save(borehole);
		bushBoreholesRepository.save(new BushBoreholes(borehole.getBush().getId(), borehole.getId()));
		
		return "redirect:/";
	}
}
