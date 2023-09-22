package com.quispesucso.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quispesucso.entity.Boleto;
import com.quispesucso.entity.Sala;
import com.quispesucso.service.SalaService;
import com.quispesucso.service.SucursalService;

@Controller
public class SalaController 
{
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SucursalService sucursalService;
	
	@GetMapping("/salas")
	public String listar_GET(Map map)
	{
		map.put("bSalas", salaService.findAll());
		return "Sala/listar";
	}
	
	@GetMapping("/sala/registrar")
	public String registrar_GET(Model model)
	{
		Sala salaNull = new Sala();
		model.addAttribute("sala",salaNull);
		
		model.addAttribute("bSucursales",sucursalService.findAll());
		
		return "Sala/registrar";
	}
	
	@PostMapping("/sala/registrar")
	public String registrar_POST(Sala sala)
	{
		salaService.insert(sala);
		return "redirect:/salas";
	}
	
	@GetMapping("/sala/editar/{salaId}")
	public String editar_GET(Model model, @PathVariable Integer salaId)
	{
		Sala salaDb = salaService.findById(salaId);
		model.addAttribute("sala",salaDb);
		
		model.addAttribute("bSucursales",sucursalService.findAll());
		
		return "Sala/editar";
	}
	
	@PostMapping("/sala/editar/{salaId}")
	public String editar_POST(Sala sala) 
	{
		salaService.update(sala);
		return "redirect:/salas";
	}
	
	@GetMapping("/sala/borrar/{salaId}")
	public String borrar_GET(Model model, @PathVariable Integer salaId)
	{
		Sala salaDb = salaService.findById(salaId);
		model.addAttribute("sala",salaDb);
		
		return "Sala/borrar";
	}
	
	@PostMapping("/sala/borrar/{salaId}")
	public String borrar_POST(Sala sala)
	{
		salaService.delete(sala.getSalaId());
		return "redirect:/salas";
	}
	
	@GetMapping("/sala/detalle/{salaId}")
	public String detalle_GET(Model model,@PathVariable Integer salaId)
	{
		Sala salaDb =salaService.findById(salaId);
		model.addAttribute("sala",salaDb);
		
		return "Sala/detalle";
	}
	
	@RequestMapping(value="/sala/detalle/{salaId}",method=RequestMethod.POST,params="btnHome")
	public String detalle_POST1()
	{
		return "redirect:/home";
	}
	
	@RequestMapping(value="/sala/detalle/{salaId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/salas";
	}
	
}
