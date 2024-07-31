package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDao;
import com.distribuida.entities.Autor;


@Controller
@RequestMapping("/Autors")       //paht principal
public class AutorController {
	
	// JSP .- Java Server Page, son las paginas web de tecnologia java
	@Autowired
	private AutorDao AutorDao;
	
	@GetMapping("/findAll")        //paht secundario
	public String findAll (Model model) {
		//try {
			List<Autor> Autors = AutorDao.findAll();
			
			model.addAttribute("Autor", Autors);
			
			return "Listar-Clinetes";  //Esto es el nombre del formulario .html
	//	}catch(Exception e) {
			
			
		}
	
	
	@GetMapping("/findOne")
	public String finOne(@RequestParam("idAutor")@Nullable Integer idAutor, 
	                     @RequestParam("opcion")@Nullable Integer opcion,
	                     Model model
	)
	{
		if(idAutor!=null) {
			Autor Autor = AutorDao.findOne(idAutor);
			model.addAttribute("Autor",Autor);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		}
		//Actualizacion
		if(opcion==1) return "add-Autors";
		//Eliminacion
		else return "del-Autors";
	}
	@PostMapping ("/add")
	public String add( @RequestParam("id_autor") @Nullable Integer idAutor,
		               @RequestParam("nombre") @Nullable String nombre,
		               @RequestParam("apellido") @Nullable String apellido,
		               @RequestParam("pais") @Nullable String pais,
		               @RequestParam("direccion") @Nullable String direccion,
		               @RequestParam("telefono") @Nullable String telefono,
		               @RequestParam("correo") @Nullable String correo,
			           ModelMap modelMap
			          ) {
		//try {
		if(idAutor == null) {
			Autor Autor = new Autor(0, nombre, apellido, direccion, telefono, correo, correo);
			AutorDao.add(Autor);
			
			}else {
				Autor Autor2 = new Autor(0, nombre, apellido, direccion, telefono, correo, correo);
				AutorDao.up(Autor2);
			}
	
	return "redirect:/Autors/findAll";   //ir al formulario web
//	}catch (Exception e){}
}
	//try {
	@GetMapping("/del")
	public String del(@RequestParam("idAutor")@Nullable Integer idAutor) {
		AutorDao.del(idAutor);
		return "redirect:/Autors/findAll";
//		}catch (Exception e){}	
	}
}
 
