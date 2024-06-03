package com.distribuida.entities;

import org.springframework.stereotype.Component;

@Component
public class Categoria {
 //atributos
	private int idCategoria;
	private String categoria;
	private String descripcion;
	
	public Categoria() {}
	public Categoria(int idCategoria, String categoria, String descripcion) {
	
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
