package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDao;
import com.distribuida.entities.Autor;


public class PrincipalAutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AutorDao autorDao = context.getBean("autorDaoImpl" , AutorDao.class);
		List<Autor> autores= autorDao.findAll();
		
		autores.forEach(item -> {
			System.out.println(item.toString());
			
			
		});

		
		context.close();
		
	}

}
