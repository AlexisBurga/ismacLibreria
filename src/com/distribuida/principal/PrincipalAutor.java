package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDao;
import com.distribuida.entities.Autor;
import com.distribuida.entities.Cliente;


public class PrincipalAutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AutorDao autorDao = context.getBean("autorDaoImpl" , AutorDao.class);
		
		Autor autor= new Autor(0, "Axel", "Lema", "Ecuador", "Av. por ahi y mas allá", "0996325874", "plema@correo.com");
		//autorDao.add(autor);
		Autor autor2= new Autor(2, "Axel2", "Lema", "Ecuador", "Av. por ahi y mas allá", "0996325874", "plema@correo.com");
		autorDao.up(autor2);
		
		//autorDao.del(1);
		
		System.out.println("******************* DEL *******************"+autorDao.findOne(1));
		autorDao.findAll().forEach(item -> {System.out.println(item.toString());});
				
		
		//List<Autor> autores= autorDao.findAll();
		
		///autores.forEach(item -> {
			//System.out.println(item.toString());
			
	

		
		context.close();
		
	}

}

