package com.practica.modem.drilling_rigs.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.modem.drilling_rigs.data.BoreholeRepository;
import com.practica.modem.drilling_rigs.data.BushRepository;
import com.practica.modem.drilling_rigs.data.TypeDrillingRepository;
import com.practica.modem.drilling_rigs.entity.Borehole;import com.practica.modem.drilling_rigs.entity.Bush;



@Controller
public class HomeController {
	
	@Autowired
	private BoreholeRepository boreholeRepo;
	
	@Autowired
	private BushRepository bushRepository;
	
	@Autowired
	private TypeDrillingRepository typeDrillingRepository;
	
	@RequestMapping("/")
	public String showHomePage(Model model)
	{
		
		model.addAttribute("boreholes", boreholeRepo.findAll());
		return "home";
	}
	
	@GetMapping("/addNewBorehole")
	public String showAddNewBorehole(Model model) {
		
		Borehole borehole = new Borehole();
		model.addAttribute("borehole", borehole);
		model.addAttribute("bushes", bushRepository.findAll());
		model.addAttribute("types", typeDrillingRepository.findAll());
		
		long idType = 0;
		model.addAttribute("idType", idType);
		
		long idBush = 0;
		model.addAttribute("idBush", idBush);
		return "addBorehole";
	}
	
	@PostMapping
	public String save(@ModelAttribute("borehole") Borehole borehole, @ModelAttribute("idType") long idType, @ModelAttribute("idBush") long idBush) {
		borehole.setBush(bushRepository.findById(idBush).get());
		borehole.setTypeDrilling(typeDrillingRepository.findById(idType).get());
		
		boreholeRepo.save(borehole);
		return "redirect:/";
	}
	
}
