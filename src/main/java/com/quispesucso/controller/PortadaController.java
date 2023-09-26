package com.quispesucso.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.quispesucso.entity.Portada;
import com.quispesucso.service.PortadaService;

@Controller
public class PortadaController 
{
	@Autowired
	private PortadaService portadaService;
	
	public PortadaController() {}
	
	@GetMapping("/portadas")
	public String listar_GET(Map map) 
	{
		map.put("bPortadas", portadaService.findAll());
		
		return "Portada/listar";
	}
	
	@GetMapping("/portada/registrar")
	public String registrar_GET(Model model) 
	{
		return "Portada/registrar";
	}
	
	@PostMapping("/portada/registrar")
	public String registrar_POST(@RequestPart("picture")MultipartFile picture) 
			throws IOException 
	{
		Portada portada = new Portada();
		portada.setNombre(picture.getOriginalFilename());
		portada.setArchivo(picture.getBytes());
		
		portadaService.insert(portada);
		
		return "redirect:/portadas";
	}
	
	@GetMapping("/portada/editar/{portadaId}")
	public String editar_GET(Model model,@PathVariable Integer portadaId) 
	{
		Portada portadaDb = portadaService.findById(portadaId);
		model.addAttribute("portada",portadaDb);
		
		return "Portada/editar";
	}
	
	@PostMapping("/portada/editar/{portadaId}")
	public String editar_POST(@PathVariable Integer portadaId, 
			@RequestPart ("picture")MultipartFile picture) throws IOException
	{
		Portada portada = new Portada();
		portada.setPortadaId(portadaId);
		portada.setNombre(picture.getOriginalFilename());
		portada.setArchivo(picture.getBytes());
		
		portadaService.insert(portada);
		
		return "redirect:/portadas";
	}
	
	@GetMapping("/portada/borrar/{portadaId}")
	public String borrar_GET(Model model, @PathVariable Integer portadaId) 
	{
		Portada portadaDb = portadaService.findById(portadaId);
		model.addAttribute("portada",portadaDb);
		
		return "Portada/borrar";
	}
	
	@PostMapping("/portada/borrar/{portadaId}")
	public String borrar_POST(@PathVariable Integer portadaId) 
	{
		portadaService.delete(portadaId);
		
		return "redirect:/portadas";
	}
	
	@GetMapping("/portada/detalle/{portadaId}")
	public String detalle_GET(Model model, @PathVariable Integer portadaId)
	{
		Portada portadaDb = portadaService.findById(portadaId);
		model.addAttribute("portada",portadaDb);
		
		return "Portada/detalle";
	}
	
	@RequestMapping(value="/portada/detalle/{portadaId}",method=RequestMethod.POST,params="btnHome")
	public String detalle_POST1()
	{
		return "redirect:/home";
	}
	
	@RequestMapping(value="/portada/detalle/{portadaId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/portadas";
	}
	
}
