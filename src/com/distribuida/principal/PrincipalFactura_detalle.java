package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.FacturaDao;
import com.distribuida.dao.Factura_detalleDao;
import com.distribuida.dao.LibroDao;
import com.distribuida.entities.Factura_detalle;

public class PrincipalFactura_detalle {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			
			Factura_detalleDao facturaDao = context.getBean("factura_detalleDaoImpl", Factura_detalleDao.class);
			FacturaDao facturaDao2 = context.getBean("facturaDaoImpl", FacturaDao.class);
			LibroDao libroDao = (LibroDao) context.getBean("libroDaoImpl", FacturaDao.class);
			
			///CRUD ; CREATE; READ; UPDATE; DELETE
			
			//ADD
			Factura_detalle factura_detalle = new Factura_detalle(1, 2, 39.90),
			factura_detalleDao.add(factura_detalleDao);
			
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
			//factura_detalleDao.findAll().forEach(item -> {System.out.println(item.toString());});
			
		
			
			context.close();

		}

	}

