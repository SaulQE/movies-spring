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

import com.quispesucso.entity.Cliente;
import com.quispesucso.service.BoletoService;
import com.quispesucso.service.ClienteService;

@Controller
public class ClienteController 
{
	@Autowired
	private ClienteService clienteService;
	
	
	public ClienteController() {}
	
	@GetMapping("/clientes")
	public String listar_GET(Map map)
	{
		map.put("bClientes", clienteService.findAll());
		return "Cliente/listar";
	}
	
	@GetMapping("/cliente/registrar")
	public String registrar_GET(Model model)
	{
		Cliente clienteNull=new Cliente();
		model.addAttribute("cliente",clienteNull);
		
		return "Cliente/registrar";
	}
	
	@PostMapping("/cliente/registrar")
	public String registrar_POST(Cliente cliente)
	{
		//guardar en la BD
		clienteService.insert(cliente);
		
		return "redirect:/clientes";
	}
	
	@GetMapping("/cliente/editar/{clienteId}")
	public String editar_GET(Model model,@PathVariable Integer clienteId)
	{
		Cliente clienteDb=clienteService.findById(clienteId);
		model.addAttribute("cliente",clienteDb);
		
		return "Cliente/editar";
	}

	@PostMapping("/cliente/editar/{clienteId}")
	public String editar_POST(Cliente cliente)
	{
		//actualizar en la BD
		clienteService.update(cliente);
		
		return "redirect:/clientes";
	}
	
	@GetMapping("/cliente/borrar/{clienteId}")
	public String borrar_GET(Model model,@PathVariable Integer clienteId)
	{
		Cliente clienteDb=clienteService.findById(clienteId);
		model.addAttribute("cliente",clienteDb);
		
		return "Cliente/borrar";
	}
	
	@PostMapping("/cliente/borrar/{clienteId}")	
	public String borrar_POST(Cliente cliente)
	{
		//borrar de la BD
		clienteService.delete(cliente.getClienteId());
		
		return "redirect:/clientes";
	}
	
	@GetMapping("/cliente/detalle/{clienteId}")
	public String detalle_GET(Model model,@PathVariable Integer clienteId)
	{
		Cliente clienteDb=clienteService.findById(clienteId);
		model.addAttribute("cliente",clienteDb);
		
		return "Cliente/detalle";
	}
	
	@RequestMapping(value="/cliente/detalle/{clienteId}",method=RequestMethod.POST,params="btnHome")
	public String detalle_POST1()
	{
		return "redirect:/home";
	}
	
	@RequestMapping(value="/cliente/detalle/{clienteId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/clientes";
	}
	
}
