package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ClienteDao;
import com.distribuida.entities.Cliente;
 
@Controller
@RequestMapping("/clientes")       //paht principal
public class ClienteController {
	
	// JSP .- Java Server Page, son las paginas web de tecnologia java
	@Autowired
	private ClienteDao clienteDao;
	
	@GetMapping("/findAll")        //paht secundario
	public String findAll (Model model) {
		//try {
			List<Cliente> clientes = clienteDao.findAll();
			
			model.addAttribute("Cliente", clientes);
			
			return "Listar-Clinetes";  //Esto es el nombre del formulario .html
	//	}catch(Exception e) {
			
			
		}
	
	
	@GetMapping("/findOne")
	public String finOne(@RequestParam("idCliente")@Nullable Integer idCliente, 
	                     @RequestParam("opcion")@Nullable Integer opcion,
	                     Model model
	)
	{
		if(idCliente!=null) {
			Cliente cliente = clienteDao.findOne(idCliente);
			model.addAttribute("cliente",cliente);
		}
		//Actualizacion
		if(opcion==1) return "add-clientes";
		//Eliminacion
		else return "del-clientes";
	}
	@PostMapping ("/add")
	public String add(@RequestParam("idCliente")@Nullable Integer idCliente,
			          @RequestParam("cedula")@Nullable String cedula,
			          @RequestParam("nombre")@Nullable String nombre,
			          @RequestParam("apellido")@Nullable String apellido,
			          @RequestParam("direccion")@Nullable String direccion,
			          @RequestParam("telefono")@Nullable String telefono,
			          @RequestParam("correo")@Nullable String correo,
			          Model model
			          ) {
		//try {
		if(idCliente == null) {
			Cliente cliente = new Cliente(0, cedula, nombre, apellido, direccion, telefono, correo);
			clienteDao.add(cliente);
			
			}else {
				Cliente cliente2 = new Cliente(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
				clienteDao.up(cliente2);
			}
	
	return "redirect:/clientes/findAll";   //ir al formulario web
//	}catch (Exception e){}
}
	//try {
	@GetMapping("/del")
	public String del(@RequestParam("idCliente")@Nullable Integer idCliente) {
		clienteDao.del(idCliente);
		return "redirect:/clientes/findAll";
//		}catch (Exception e){}	
	}
}
 