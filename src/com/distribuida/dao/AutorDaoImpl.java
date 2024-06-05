package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Autor;


@Repository
public class AutorDaoImpl implements AutorDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    @Transactional
    public List<Autor> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Autor", Autor.class).getResultList();
    }
    @Override
 	public Autor findOne(int id) {
 		// TODO Auto-generated method stub
 		return null;
 	}

	
    @Override
	public void add(Autor autor) {
		// TODO Auto-generated method stub

	}
	@Override
	public void up(Autor autor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub

	}

}