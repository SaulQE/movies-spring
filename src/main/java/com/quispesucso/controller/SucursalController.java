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

import com.quispesucso.entity.Sucursal;
import com.quispesucso.service.SucursalService;

@Controller
public class SucursalController 
{
	@Autowired
	private SucursalService sucursalService;
	
	public SucursalController() {}
	
	@GetMapping("/sucursales")
	public String listar_GET(Map map) 
	{
		map.put("bSucursales", sucursalService.findAll());
		
		return "Sucursal/listar";
	}
	
	@GetMapping("/sucursal/registrar")
	public String registrar_GET(Model model) 
	{
		Sucursal sucursalNull = new Sucursal();
		model.addAttribute("sucursal",sucursalNull);
		
		return "Sucursal/registrar";
	}
	
	@PostMapping("/sucursal/registrar")
	public String registrar_POST(Sucursal sucursal) 
	{		
		sucursalService.insert(sucursal);
		
		return "redirect:/sucursales";
	}
	
	@GetMapping("/sucursal/editar/{sucursalId}")
	public String editar_GET(Model model, @PathVariable Integer sucursalId) 
	{
		Sucursal sucursalDb = sucursalService.findById(sucursalId);
		model.addAttribute("sucursal",sucursalDb);
		
		return "Sucursal/editar";
	}
	
	@PostMapping("/sucursal/editar/{sucursalId}")
	public String editar_POST(Sucursal sucursal) 
	{		
		sucursalService.update(sucursal);
		
		return "redirect:/sucursales";
	}
	
	@GetMapping("/sucursal/borrar/{sucursalId}")
	public String borrar_GET(Model model, @PathVariable Integer sucursalId)
	{
		Sucursal sucursalDb = sucursalService.findById(sucursalId);
		model.addAttribute("sucursal",sucursalDb);
		
		return "Sucursal/borrar";
	}
	
	@PostMapping("/sucursal/borrar/{sucursalId}")
	public String borrar_POST(Sucursal sucursal) 
	{
		sucursalService.delete(sucursal.getSucursalId());
		return "redirect:/sucursales";
	}
	
	@GetMapping("/sucursal/detalle/{sucursalId}")
	public String detalle_GET(Model model, @PathVariable Integer sucursalId)
	{
		Sucursal sucursalDb = sucursalService.findById(sucursalId);
		model.addAttribute("sucursal", sucursalDb);
		
		return "Sucursal/detalle";
	}
	
	@RequestMapping(value="/sucursal/detalle/{sucursalId}",method=RequestMethod.POST,params="btnHome")
	public String detalle_POST1()
	{
		return "redirect:/home";
	}
	
	@RequestMapping(value="/sucursal/detalle/{sucursalId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/sucursales";
	}
	
}
