package com.practica.modem.drilling_rigs.controllers;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.TargetLostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.practica.modem.drilling_rigs.data.BoreholeBarrelRepository;
import com.practica.modem.drilling_rigs.data.BoreholeRepository;
import com.practica.modem.drilling_rigs.data.BushBoreholesRepository;
import com.practica.modem.drilling_rigs.data.BushRepository;
import com.practica.modem.drilling_rigs.data.TypeDrillingRepository;
import com.practica.modem.drilling_rigs.entity.Barrel;
import com.practica.modem.drilling_rigs.entity.Borehole;import com.practica.modem.drilling_rigs.entity.Bush;
import com.practica.modem.drilling_rigs.entity.TypeDrilling;



@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private BoreholeRepository boreholeRepo;
	
	@Autowired
	private BushRepository bushRepository;
	
	@Autowired
	private TypeDrillingRepository typeDrillingRepository;
	
	@Autowired
	private BushBoreholesRepository bushBoreholesRepository;
	
	@Autowired
	private BoreholeBarrelRepository boreholeBarrelRepository;
	
	@GetMapping
	public String showHomePage(Model model)
	{
		
		model.addAttribute("boreholes", boreholeRepo.findAll());
		Borehole borehole = null;
		model.addAttribute("boreholeForDetails", borehole);
		return "home";
	}
	
//	@GetMapping("borehole_details")
//	public String showDetails(@RequestParam("borehole_id") Long idBorehole, Model model)
//	{
//		List<Barrel> barells = boreholeRepo.findById(idBorehole).get().getBarrels();
//		model.addAttribute("barrels", barells);
//		
//		return "borehole_details";
//	}
	
	
	
	@PostMapping("deleteBorehole")
	public String deleteBorehole(@RequestParam("borehole_id") Long idBorehole)
	{
		bushBoreholesRepository.deleteAll(bushBoreholesRepository.findByIdBorehole(idBorehole));
		boreholeBarrelRepository.deleteAll(boreholeBarrelRepository.findByIdBorehole(idBorehole));
		boreholeRepo.deleteById(idBorehole);
		
		return "redirect:/";
	}
	
	
}
