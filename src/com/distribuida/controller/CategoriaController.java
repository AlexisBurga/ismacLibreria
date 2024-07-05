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

import com.distribuida.dao.CategoriaDao;
import com.distribuida.entities.Categoria;



@Controller
@RequestMapping("/Categorias")       //paht principal
public class CategoriaController {
	
	// JSP .- Java Server Page, son las paginas web de tecnologia java
	@Autowired
	private CategoriaDao CategoriaDao;
	
	@GetMapping("/findAll")        //paht secundario
	public String findAll (ModelMap modelMap) {
		//try {
			List<Categoria> Categorias = CategoriaDao.findAll();
			
			modelMap.addAttribute("Categoria", Categorias);
			
			return "Listar-Clinetes";  //Esto es el nombre del formulario .html
	//	}catch(Exception e) {
			
			
		}
	
	
	@GetMapping("/findOne")
	public String finOne(@RequestParam("idCategoria")@Nullable Integer idCategoria, 
	                     @RequestParam("opcion")@Nullable Integer opcion,
	                     Model model
	)
	{
		if(idCategoria!=null) {
			Categoria Categoria = CategoriaDao.findOne(idCategoria);
			model.addAttribute("Categoria",Categoria);
		}
		//Actualizacion
		if(opcion==1) return "add-Categorias";
		//Eliminacion
		else return "del-Categorias";
	}
	@PostMapping ("/add")
	public String add(@RequestParam("id_categoria") @Nullable Integer idCategoria,
		              @RequestParam("categoria") @Nullable String categoria,
		              @RequestParam("descripcion") @Nullable String descripcion,
		              Model model
			          ) {
		//try {
		if(idCategoria == null) {
			Categoria Categoria = new Categoria();
			CategoriaDao.add(Categoria);
			
			}else {
				Categoria Categoria2 = new Categoria();
				CategoriaDao.up(Categoria2);
			}
	
	return "redirect:/Categorias/findAll";   //ir al formulario web
//	}catch (Exception e){}
}
	//try {
	@GetMapping("/del")
	public String del(@RequestParam("idCategoria")@Nullable Integer idCategoria) {
		CategoriaDao.del(idCategoria);
		return "redirect:/Categorias/findAll";
//		}catch (Exception e){}	
	}
}
 