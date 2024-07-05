package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Factura_detalle;

public interface Factura_detalleDao {

	public List<Factura_detalle>findAll();
	public Factura_detalle findOne(int id);
	public void add(Factura_detalle factura_detalle);
	public void up(Factura_detalle factura_detalle);
	public void del(int id);
	public static void setFactura(Factura_detalle one) {
		// TODO Auto-generated method stub
		
	}
	

}
