package com.distribuida.dao;

import java.util.List;
import com.distribuida.entities.Cliente;

public interface ClienteDao {
	
	//CRUD BASICO
	public List<Cliente>findAll();
	public Cliente findOne(int id);
	public void add(Cliente cliente);
	public void up(Cliente cliente);
	public void del(int id);
	
	//CRUD AVANZADO
	
	



}
