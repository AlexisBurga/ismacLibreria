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
import com.distribuida.dao.FacturaDao;
import com.distribuida.entities.Factura;



@Controller
@RequestMapping("/Facturas")       //paht principal
public class FacturaController {
	
	// JSP .- Java Server Page, son las paginas web de tecnologia java
	@Autowired
	private FacturaDao FacturaDao;
	
	@GetMapping("/findAll")        //paht secundario
	public String findAll (ModelMap modelMap) {
		//try {
			List<Factura> Facturas = FacturaDao.findAll();
			
			modelMap.addAttribute("Factura", Facturas);
			
			return "Listar-Clinetes";  //Esto es el nombre del formulario .html
	//	}catch(Exception e) {
			
			
		}
	
	
	@GetMapping("/findOne")
	public String finOne(@RequestParam("idFactura")@Nullable Integer idFactura, 
	                     @RequestParam("opcion")@Nullable Integer opcion,
	                     ModelMap modelMap
	)
	{
		if(idFactura!=null) {
			Factura Factura = FacturaDao.findOne(idFactura);
			modelMap.addAttribute("Factura",Factura);
		}
		modelMap.addAttribute("autores",AutorDao.findAll());
		modelMap.addAttribute("categorias",CategoriaDao.findAll());
		
		//Actualizacion
		if(opcion==1) return "add-Facturas";
		//Eliminacion
		else return "del-Facturas";
	} 
	@PostMapping ("/add")
	public String add(@RequestParam("idFactura")@Nullable Integer idFactura,
			    @RequestParam("num_factura") @Nullable String numFactura,
			    @RequestParam("fecha") @Nullable Date fecha,
			    @RequestParam("total_neto") @Nullable Float totalNeto,
			    @RequestParam("iva") @Nullable Float iva,
			    @RequestParam("total") @Nullable Float total,
			    @RequestParam("id_cliente") @Nullable Integer idCliente,
			    @RequestParam("version") @Nullable Integer version,
			          ModelMap modelMap
			          ) {
		//try {
		if(idFactura == null) {
			Factura Factura = new Factura();
			FacturaDao.add(Factura);
			
			}else {
				Factura Factura2 = new Factura();
				FacturaDao.up(Factura2);
			}
	
	return "redirect:/Facturas/findAll";   //ir al formulario web
//	}catch (Exception e){}
}
	//try {
	@GetMapping("/del")
	public String del(@RequestParam("idFactura")@Nullable Integer idFactura) {
		FacturaDao.del(idFactura);
		return "redirect:/Facturas/findAll";
//		}catch (Exception e){}	
	}
}
 
