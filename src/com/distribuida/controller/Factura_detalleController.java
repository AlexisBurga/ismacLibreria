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
	import com.distribuida.dao.Factura_detalleDao;
	import com.distribuida.entities.Factura_detalle;



	@Controller
	@RequestMapping("/Factura_detalles")       //paht principal
	public class Factura_detalleController {
		
		// JSP .- Java Server Page, son las paginas web de tecnologia java
		@Autowired
		private Factura_detalleDao Factura_detalleDao;
		
		@GetMapping("/findAll")        //paht secundario
		public String findAll (ModelMap modelMap) {
			//try {
				List<Factura_detalle> Factura_detalles = Factura_detalleDao.findAll();
				
				modelMap.addAttribute("Factura_detalle", Factura_detalles);
				
				return "Listar-Clinetes";  //Esto es el nombre del formulario .html
		//	}catch(Exception e) {
				
				
			}
		
		
		@GetMapping("/findOne")
		public String finOne(@RequestParam("idFactura_detalle")@Nullable Integer idFactura_detalle, 
		                     @RequestParam("opcion")@Nullable Integer opcion,
		                     ModelMap modelMap
		)
		{
			if(idFactura_detalle!=null) {
				Factura_detalle Factura_detalle = Factura_detalleDao.findOne(idFactura_detalle);
				modelMap.addAttribute("Factura_detalle",Factura_detalle);
			}
			
			//Actualizacion
			if(opcion==1) return "add-Factura_detalles";
			//Eliminacion
			else return "del-Factura_detalles";
		} 
		@PostMapping ("/add")
		public String add(@RequestParam("idFactura_detalle")@Nullable Integer idFactura_detalle,
				@RequestParam("cantidad") @Nullable Integer cantidad,
			    @RequestParam("subtotal") @Nullable Float subtotal,
			    @RequestParam("id_factura") @Nullable Integer idFactura,
			    @RequestParam("id_libro") @Nullable Integer idLibro,
				          ModelMap modelMap
				          ) {
			//try {
			if(idFactura_detalle == null) {
				Factura_detalle Factura_detalle = new Factura_detalle();
				Factura_detalleDao.add(Factura_detalle);
				
				}else {
					Factura_detalle Factura_detalle2 = new Factura_detalle();
					Factura_detalleDao.up(Factura_detalle2);
				}
		
		return "redirect:/Factura_detalles/findAll";   //ir al formulario web
//		}catch (Exception e){}
	}
		//try {
		@GetMapping("/del")
		public String del(@RequestParam("idFactura_detalle")@Nullable Integer idFactura_detalle) {
			Factura_detalleDao.del(idFactura_detalle);
			return "redirect:/Factura_detalles/findAll";
//			}catch (Exception e){}	
		}
	}
	 


