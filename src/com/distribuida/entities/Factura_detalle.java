package com.distribuida.entities;

public class Factura_detalle {
	
	private int idFactura_detalle;
	private int cantidad;
	private double subtotal;
	private Factura idFactura;
	private Libro idLibro;
	
	public Factura_detalle() {}
	public Factura_detalle(int idFactura_detalle, int cantidad, double subtotal) {
		
		this.idFactura_detalle = idFactura_detalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		
	}
	public int getIdFactura_detalle() {
		return idFactura_detalle;
	}
	public void setIdFactura_detalle(int idFactura_detalle) {
		this.idFactura_detalle = idFactura_detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "Factura_detalle [idFactura_detalle=" + idFactura_detalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + "]";
	}

	

}
