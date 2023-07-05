package com.practica.modem.drilling_rigs.controllers;

import java.text.Bidi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.modem.drilling_rigs.data.AreaRepository;
import com.practica.modem.drilling_rigs.data.BushRepository;
import com.practica.modem.drilling_rigs.entity.Area;
import com.practica.modem.drilling_rigs.entity.Bush;

@Controller
@RequestMapping("/addBush")
public class AddBushController {
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private BushRepository bushRepository;

	@GetMapping
	public String showEditBush(Model model)
	{
		Bush bush = new Bush();
		Area area = new Area();
		
		model.addAttribute("bush", bush);
		model.addAttribute("area", area);
		
		return "addBush";
	}
	
	@PostMapping
	public String saveBush(@ModelAttribute("bush") Bush bush, @ModelAttribute("area") Area area)
	{
		if(!checkUnique(bush, area))
		{
			return "redirect:/addBush";
		}
		
		areaRepository.save(area);
		
		bush.setArea(area);
		bushRepository.save(bush);
		
		return "redirect:/addNewBorehole";
	}
	
	private boolean checkUnique(Bush bush, Area area)
	{
		System.out.println(bushRepository.findByName(bush.getName()).size());
		System.out.println(areaRepository.findByAName(area.getAName()).size());
		if(bushRepository.findByName(bush.getName()).size() != 0 || areaRepository.findByAName(area.getAName()).size() != 0)
		{
			return false;
		}

		return true;
	}
}
