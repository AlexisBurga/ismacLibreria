package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDao;
import com.distribuida.entities.Cliente;



public class PrincipalCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ClienteDao clienteDao = context.getBean("clienteDaoImpl" , ClienteDao.class);
		List<Cliente> clientes= clienteDao.findAll();
		
		clientes.forEach(item -> {
			System.out.println(item.toString());
			
			
		});

		
		context.close();
		
	}

}
