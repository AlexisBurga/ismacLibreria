package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Autor;






public interface AutorDao {

	
	public List<Autor>findAll();
		// TODO Auto-generated method st
	public Autor findOne(int id);
		// TODO Auto-generated method stub
	
	public void add(Autor autor);
	public void up(Autor autor);
	public void del(int id);
	
}
