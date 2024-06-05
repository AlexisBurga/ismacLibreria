package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.distribuida.entities.Categoria;
import com.distribuida.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CategoriaDaoImpl implements CategoriaDao {
	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
	Session session= sessionFactory.getCurrentSession();
		
	return session.createQuery("from Categoria", Categoria.class).getResultList();
	}
	

	@Override
	public Categoria findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void up(Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
