package com.distribuida.principal;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDao;

import com.distribuida.dao.FacturaDao;


import com.distribuida.entities.Factura;

public class PrincipalFactura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		FacturaDao facturaDao = context.getBean("facturaDaoImpl", FacturaDao.class);
		ClienteDao clienteDao = context.getBean("clienteDaoImpl", ClienteDao.class);
		
		///CRUD ; CREATE; READ; UPDATE; DELETE
		
		//ADD
		Factura factura = new Factura(0,"FAC-0090", new Date(), 66.63, 15.36, 76.35);
		factura.setCliente(clienteDao.findOne(1));
		facturaDao.add(factura);
		
		//UP
		//Factura factura2 =new Factura(87,"FAC-0091", new Date(), 123.63, 23.36, 80.35);
		//factura2.setCliente(clienteDao.findOne(2));
		//facturaDao.up(factura2);
		
		//DEL
		//facturaDao.del(83);
		//FINDONE
		//System.out.println("********************DEL**************"+FacturaDAO.findOne(1));
		//FINDALL
		//List<Factura> Facturas =facturaDao.findAll();
		facturaDao.findAll().forEach(item -> {System.out.println(item.toString());});
		
	
		
		context.close();

	}

}

