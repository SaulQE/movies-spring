package com.quispesucso.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quispesucso.entity.Director;
import com.quispesucso.service.DirectorService;

@Controller
public class DirectorController 
{
	@Autowired
	private DirectorService directorService;
	
	public DirectorController() {}
	
	@GetMapping("/directores")
	public String listar_GET(Map map) 
	{
		map.put("bDirector", directorService.findAll());
		
		return "Director/listar";
	}
	
	@GetMapping("/director/registrar")
	public String registrar_GET(Map map) 
	{
		Director directorNull=new Director();
		map.put("director", directorNull);
		
		return "Director/registrar";
	}
	
	@PostMapping("/director/registrar")
	public String registrar_POST(Director director) 
	{
		directorService.insert(director);
		return "redirect:/directores";
	}
	
	@GetMapping("/director/editar/{directorId}")
	public String editar_GET(Map map,@PathVariable Integer directorId)
	{
		Director directorDB = directorService.findById(directorId); 
		map.put("director", directorDB);
		
		return "Director/editar";
	}
	
	@PostMapping("/director/editar/{directorId}")
	public String editar_POST(Director director)
	{
		directorService.update(director);
		return "redirect:/directores";
	}
	
	@GetMapping("/director/borrar/{directorId}")
	public String borrar_GET(Map map,@PathVariable Integer directorId)
	{
		Director directorDB =directorService.findById(directorId);
		map.put("director",directorDB);
		
		return "Director/borrar";
	}
	
	@PostMapping("/director/borrar/{directorId}")	
	public String borrar_POST(Director director)
	{
		//borrar de la BD
		directorService.delete(director.getDirectorId());
		
		return "redirect:/directores";
	}
	//
	@GetMapping("/director/detalle/{directorId}")
	public String detalle_GET(Map map,@PathVariable Integer directorId)
	{
		Director directorDB=directorService.findById(directorId);
		map.put("director",directorDB);
		
		return "Director/detalle";
	}
	
	@RequestMapping(value="/director/detalle/{directorId}",method=RequestMethod.POST,params="btnHome")
	public String detalle_POST1()
	{
		return "redirect:/home";
	}
	
	@RequestMapping(value="/director/detalle/{directorId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/directores";
	}
	
}
