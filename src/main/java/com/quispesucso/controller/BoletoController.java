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
import com.quispesucso.service.BoletoService;
import com.quispesucso.service.ClienteService;
import com.quispesucso.service.SalaService;

@Controller
public class BoletoController 
{
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/boletos")
	public String listar_GET(Map map)
	{
		map.put("bBoletos", boletoService.findAll());
		
		return "Boleto/listar";
	}
	
	@GetMapping("/boleto/registrar")
	public String registrar_GET(Model model, Map map)
	{
		Boleto boletoNull = new Boleto();
		model.addAttribute("boleto", boletoNull);
		
		map.put("bClientes", clienteService.findAll());
		model.addAttribute("bSalas", salaService.findAll());
		
		return "Boleto/registrar";
	}
	
	@PostMapping("/boleto/registrar")
	public String registrar_POST(Boleto boleto)
	{
		boletoService.insert(boleto);
		return "redirect:/boletos";
	}
	
	@GetMapping("/boleto/editar/{boletoId}")
	public String editar_GET(Model model,@PathVariable Integer boletoId)
	{
		Boleto boletoDb = boletoService.findById(boletoId);
		model.addAttribute("boleto",boletoDb);
		
		model.addAttribute("bClientes",clienteService.findAll());
		model.addAttribute("bSalas", salaService.findAll());
		
		return "Boleto/editar";
	}
	
	@PostMapping("/boleto/editar/{boletoId}")
	public String editar_POST(Boleto boleto)
	{
		boletoService.update(boleto);
		return "redirect:/boletos";
	}
	
	@GetMapping("/boleto/borrar/{boletoId}")
	public String borrar_GET(Map map,@PathVariable Integer boletoId)
	{
		Boleto boletoDb = boletoService.findById(boletoId);
		map.put("boleto", boletoDb);
		
		return "Boleto/borrar";
	}
	
	@PostMapping("/boleto/borrar/{boletoId}")
	public String borrar_POST(Boleto boleto) 
	{
		boletoService.delete(boleto.getBoletoId());
		
		return "redirect:/boletos";
	}
	
	@GetMapping("/boleto/detalle/{boletoId}")
	public String detalle_GET(Map map,@PathVariable Integer boletoId)
	{
		Boleto boletoDb =boletoService.findById(boletoId);
		map.put("boleto",boletoDb);
		
		return "Boleto/detalle";
	}
	
	@RequestMapping(value="/boleto/detalle/{boletoId}",method=RequestMethod.POST,params="btnHome")
	public String detalle_POST1()
	{
		return "redirect:/home";
	}
	
	@RequestMapping(value="/boleto/detalle/{boletoId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/boletos";
	}
	
}
