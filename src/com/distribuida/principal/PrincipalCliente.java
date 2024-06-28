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
		
		Cliente cliente= new Cliente(0,"123456789","juan","taipe","av. por ahi..","0987654321","jtaipe@correo.com");
		clienteDao.add(cliente);
		Cliente cliente2= new Cliente(1,"12784789","Anto","torres","av.Tasipe","0989755216","Antod@correo.com");
		clienteDao.up(cliente2);
		
		//clienteDao.del(1);
		
		System.out.println("******************* DEL *******************"+clienteDao.findOne(1));
		clienteDao.findAll().forEach(item -> {System.out.println(item.toString());});
		
		//List<Cliente> clientes= clienteDao.findAll();
		
		//clientes.forEach(item -> {
			//System.out.println(item.toString());
			
			

		
		context.close();
		
	}

}
