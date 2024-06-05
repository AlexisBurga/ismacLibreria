package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.distribuida.dao.CategoriaDao;

import com.distribuida.entities.Categoria;


public class PrincipalCategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CategoriaDao categoriaDao = context.getBean("categoriaDaoImpl" , CategoriaDao.class);
		List<Categoria> categorias= categoriaDao.findAll();
		
		categorias.forEach(item -> {
			System.out.println(item.toString());
			
			
		});

		
		context.close();
		
	}

}