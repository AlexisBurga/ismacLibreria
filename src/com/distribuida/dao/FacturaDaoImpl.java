package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Factura;
import java.util.List;

import javax.transaction.Transactional;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.distribuida.entities.Factura;
 
 
 
@Repository
public class FacturaDaoImpl implements FacturaDao {
	@Autowired
	private SessionFactory  sessionFactory ;

	@Override
	@Transactional
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Factura", Factura.class).getResultList();
	}
 
	@Override
	@Transactional
	public Factura findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Factura.class, id);
	}
	@Override
	@Transactional
	public void up(Factura factura) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(factura);
	}
 
	@Override
	@Transactional
	public void add(Factura factura) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(factura);
 
	}
 
	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
 
	}
 
}