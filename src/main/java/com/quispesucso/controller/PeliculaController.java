package com.quispesucso.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quispesucso.entity.Pelicula;
import com.quispesucso.service.DirectorService;
import com.quispesucso.service.PeliculaService;

@Controller
public class PeliculaController 
{
	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private DirectorService directorService;
	
	public PeliculaController() {}

	@GetMapping("/home")
	public String home_GET() 
	{
		return "home";
	}
	
	@GetMapping("/peliculas")
	public String listar_GET(Map map) 
	{
		map.put("bPeliculas", peliculaService.findAll());
		map.put("sumMinutos", peliculaService.sumMinutos());
		
		return "Pelicula/listar";
	}
	
	@GetMapping("/pelicula/registrar")
	public String registrar_GET(Map map)
	{
		Pelicula peliculaNull = new Pelicula();
		map.put("bDirector", directorService.findAll());
		
		map.put("pelicula", peliculaNull);
		/*map.put("director", new Director());*/
		
		return "Pelicula/registrar";
	}
	
	@PostMapping("/pelicula/registrar")
	public String registrar_POST(Pelicula pelicula/*, @RequestParam("directorId") Integer directorId*/)
	{
		/*Director director = directorService.findById(directorId);
		pelicula.setDirector(director);*/
		
		peliculaService.insert(pelicula);
		return "redirect:/peliculas";
	}
	
	@GetMapping("/pelicula/editar/{peliculaId}")
	public String editar_GET(Map map,@PathVariable Integer peliculaId)
	{
		Pelicula peliculaDB = peliculaService.findById(peliculaId); 
		map.put("pelicula", peliculaDB);
		
		return "Pelicula/editar";
	}
	
	@PostMapping("/pelicula/editar/{peliculaId}")
	public String editar_POST(Pelicula pelicula)
	{
		peliculaService.update(pelicula);
		return "redirect:/peliculas";
	}
	
	@GetMapping("/pelicula/borrar/{peliculaId}")
	public String borrar_GET(Map map,@PathVariable Integer peliculaId)
	{
		Pelicula peliculaDB=peliculaService.findById(peliculaId);
		map.put("pelicula",peliculaDB);
		
		return "Pelicula/borrar";
	}
	
	@PostMapping("/pelicula/borrar/{peliculaId}")	
	public String borrar_POST(Pelicula pelicula)
	{
		//borrar de la BD
		peliculaService.delete(pelicula.getPeliculaId());
		
		return "redirect:/peliculas";
	}
	
	@GetMapping("/pelicula/detalle/{peliculaId}")
	public String detalle_GET(Map map,@PathVariable Integer peliculaId)
	{
		Pelicula peliculaDB=peliculaService.findById(peliculaId);
		map.put("pelicula",peliculaDB);
		
		return "Pelicula/detalle";
	}
	
	@RequestMapping(value="/pelicula/detalle/{peliculaId}",method=RequestMethod.POST,params="btnHome")
	public String detalle_POST1()
	{
		return "redirect:/home";
	}
	
	@RequestMapping(value="/pelicula/detalle/{peliculaId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/peliculas";
	}
	
}
