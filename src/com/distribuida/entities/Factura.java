package com.distribuida.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
import org.springframework.stereotype.Component;
 
@Component
@Entity
@Table (name="factura")
 
 
public class Factura {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_factura")
	private int idFactura;
	@Column (name ="num_factura")
	private String numFactura;
	@Column (name ="fecha")
	private Date fecha;
	@Column (name = "total_neto")
	private double totalNeto;
	@Column (name= "iva")
	private double iva;
	@Column (name ="total")
	private double total;
	//private int idCliente;

	@JoinColumn(name = "id_cliente")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Cliente cliente;
	public Factura() {}
	public Factura(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total)  {
		this.idFactura = idFactura;
		this.numFactura = numFactura;
		this.fecha = fecha;
		this.totalNeto = totalNeto;
		this.iva = iva;
		this.total = total;
 
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getTotalNeto() {
		return totalNeto;
	}
	public void setTotalNeto(double totalNeto) {
		this.totalNeto = totalNeto;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente idCliente) {
		this.cliente = idCliente;
	}
	public void setVersion(Integer version) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", numFactura=" + numFactura + ", fecha=" + fecha + ", totalNeto="
				+ totalNeto + ", iva=" + iva + ", total=" + total + ", cliente=" + cliente + "]";
	}
	
	
}
