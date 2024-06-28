package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.distribuida.entities.Factura_detalle;

public class Factura_detalleDaoImpl implements Factura_detalleDao {
	
	@Autowired
	private SessionFactory  sessionFactory ;

	@Override
	@Transactional
	
	public List<Factura_detalle> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Factura_detalle", Factura_detalle.class).getResultList();
	}

	@Override
	public Factura_detalle findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Factura_detalle.class, id);
	}
	

	@Override
	public void add(Factura_detalle factura_detalle) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(factura_detalle);

	}

	@Override
	public void up(Factura_detalle factura_detalle) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(factura_detalle);
 

	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
	}


}
