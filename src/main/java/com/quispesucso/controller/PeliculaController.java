package com.quispesucso.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quispesucso.entity.Pelicula;
import com.quispesucso.entity.Sala;
import com.quispesucso.service.DirectorService;
import com.quispesucso.service.PeliculaService;
import com.quispesucso.service.PortadaService;
import com.quispesucso.service.SalaService;

@Controller
public class PeliculaController 
{
	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private DirectorService directorService;
	
	@Autowired
	private PortadaService portadaService;
	
	@Autowired
	private SalaService salaService;
	
	private Collection<Sala> carrito = null;
	
	public PeliculaController() {}
	
	@GetMapping("/peliculas")
	public String listar_GET(Map map) 
	{
		map.put("bPeliculas", peliculaService.findAll());
		map.put("sumMinutos", peliculaService.sumMinutos());
		
		return "Pelicula/listar";
	}
	
	@GetMapping("/pelicula/registrar")
	public String registrar_GET(Model model ,Map map)
	{
		Pelicula peliculaNull = new Pelicula();
		map.put("pelicula", peliculaNull);
		
		model.addAttribute("bDirectores", directorService.findAll());
		model.addAttribute("bPortadas",portadaService.PortadaSinRelacionar());		
		
		return "Pelicula/registrar";
	}
	
	@PostMapping("/pelicula/registrar")
	public String registrar_POST(Pelicula pelicula)
	{	
		peliculaService.insert(pelicula);
		return "redirect:/peliculas";
	}
	
	@GetMapping("/pelicula/editar/{peliculaId}")
	public String editar_GET(Model model,Map map,@PathVariable Integer peliculaId)
	{
		Pelicula peliculaDB = peliculaService.findById(peliculaId); 
		model.addAttribute("pelicula", peliculaDB);
		
		model.addAttribute("bDirectores", directorService.findAll());
		model.addAttribute("bPortadas",portadaService.PortadaSinRelacionar());		
		
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
	
	@GetMapping("/pelicula/sala_agregar/{peliculaId}")
	public String sala_agregar_GET(Model model,Map map,@PathVariable Integer peliculaId,
            @RequestParam(defaultValue="false") boolean flag)
	{
		Pelicula peliculaDb = peliculaService.findById(peliculaId);
		if (flag==false) {
			carrito=this.convert(peliculaService.peliculas_sala(peliculaId));
		}
		model.addAttribute("pelicula",peliculaDb);
		
		map.put("bSalas1", salaService.findAll());
		map.put("bSalas2", carrito);
		
		return "Pelicula/sala_agregar";
	}
	
	@GetMapping("/pelicula_sala/agregar/{salaId}/{peliculaId}")
	public String agregar_carrito_GET(@PathVariable Integer salaId, @PathVariable Integer peliculaId)
	{
		Sala salaDb = salaService.findById(salaId);
		carrito.add(salaDb);
		
		return "redirect:/pelicula/sala_agregar/"+peliculaId+"?flag=true";
	}
	
	@PostMapping("/pelicula/sala_agregar/{peliculaId}")
	public String sala_agregar_POST(@PathVariable Integer peliculaId)
	{
		Pelicula peliculaDb = peliculaService.findById(peliculaId);
		
		for(Sala sala:carrito) {
			peliculaDb.addSala(sala);
		}
		
		peliculaService.update(peliculaDb);
		
		return "redirect:/peliculas";
	}
	
	public Collection<Sala> convert(Collection<Object[]> objects)
	{
		Collection<Sala> salas = new ArrayList<>();
		
		for(Object[] object:objects)
		{
			Integer salaId = Integer.parseInt(object[0].toString());
			Sala salaDb = salaService.findById(salaId);
			
			salas.add(salaDb);
		}
		return salas;
	}
	
}
