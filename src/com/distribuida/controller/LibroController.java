package com.distribuida.controller;

import java.util.Date;
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
import com.distribuida.dao.CategoriaDao;
import com.distribuida.dao.LibroDao;
import com.distribuida.entities.Libro;



@Controller
@RequestMapping("/libros")       //paht principal
public class LibroController {
	
	
	@Autowired
	private LibroDao libroDao;
	private CategoriaDao categoriaDao;
	private AutorDao autorDao;
	
	@GetMapping("/findAll")        //paht secundario
	public String findAll (ModelMap modelMap) {
		//try {
			List<Libro> Libros = libroDao.findAll();
			
			modelMap.addAttribute("Libros", Libros);
			
			return "listar-libros";  //Esto es el nombre del formulario .html
	//	}catch(Exception e) {
			
			
		}
	
	
	@GetMapping("/findOne")
	public String finOne(@RequestParam("idLibro")@Nullable Integer idLibro, 
	                     @RequestParam("opcion")@Nullable Integer opcion,
	                     ModelMap modelMap
	)
	{
		if(idLibro!=null) {
			Libro Libro = libroDao.findOne(idLibro);
			modelMap.addAttribute("Libro",Libro);
		}

		modelMap.addAttribute("autores", autorDao.findAll());
		modelMap.addAttribute("categorias",categoriaDao.findAll());
		
		//Actualizacion
		if(opcion==1) return "add-Libros";
		//Eliminacion
		else return "del-Libros";
	} 
	@PostMapping ("/add")
	public String add(@RequestParam("idLibro")@Nullable Integer id_libro,
			 @RequestParam("titulo") @Nullable String titulo,
			    @RequestParam("editorial") @Nullable String editorial,
			    @RequestParam("num_paginas") @Nullable Integer numPaginas,
			    @RequestParam("edicion") @Nullable String edicion,
			    @RequestParam("idioma") @Nullable String idioma,
			    @RequestParam("fecha_publicacion") @Nullable Date fechaPublicacion,
			    @RequestParam("descripcion") @Nullable String descripcion,
			    @RequestParam("tipo_pasta") @Nullable String tipoPasta,
			    @RequestParam("ISBN") @Nullable String ISBN,
			    @RequestParam("num_ejemplares") @Nullable Integer numEjemplares,
			    @RequestParam("portada") @Nullable String portada,
			    @RequestParam("presentacion") @Nullable String presentacion,
			    @RequestParam("precio") @Nullable Float precio,
			    @RequestParam("id_categoria") @Nullable Integer id_categoria,
			    @RequestParam("id_autor") @Nullable Integer id_autor,
			          ModelMap modelMap
			          ) {
		//try {
		if(id_libro == null) {
			Libro libro = new Libro(0,titulo,editorial,numPaginas,edicion,idioma,fechaPublicacion,descripcion,tipoPasta,ISBN,numEjemplares,portada,presentacion,precio);
			libro.setIdCategoria(categoriaDao.findOne(id_categoria));
			libro.setIdAutor(autorDao.findOne(id_autor));
			libroDao.add(libro);
			
			}else {
				if(id_libro == null) {
					Libro libro = new Libro(id_libro, titulo,editorial, numPaginas, edicion, idioma, fechaPublicacion, descripcion, tipoPasta, ISBN, numEjemplares, portada, presentacion, precio);
					libro.setIdCategoria(categoriaDao.findOne(id_categoria));
					libro.setIdAutor(autorDao.findOne(id_autor));
					
					libroDao.up(libro);
			}
			return "redirect:/libro/listar-libros";
			
	}
		//try {
		@GetMapping("/del")
		public String del(@RequestParam("idFactura")@Nullable Integer id_libro) {
			libroDao.del(id_libro);
			return "redirect:/Facturas/findAll";
//			}catch (Exception e){}	
		}
	}
 