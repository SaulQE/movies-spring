package com.quispesucso.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String registrar_POST(@RequestPart("picture")MultipartFile picture) throws IOException 
	{
		Portada portada = new Portada();
		portada.setNombre(picture.getOriginalFilename());
		portada.setArchivo(picture.getBytes());
		
		portadaService.insert(portada);
		
		return "redirect:/portadas";
	}
	
}
