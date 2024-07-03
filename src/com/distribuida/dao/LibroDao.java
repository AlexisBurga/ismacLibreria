package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Libro;

public interface LibroDao {
	
    public List<Libro>findAll();

	public Libro findOne(int id);	
	public void add(Libro libro);
	public void up(Libro libro);
	public void del(int id);
}
