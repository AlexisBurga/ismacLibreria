package com.distribuida.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Atributos
	@Column(name = "id_autor")
	private int idAutor;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "pais")
	private String pais;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "correo")
	private String correo;
	
	public Autor(){}
	public Autor(int idAutor, String nombre, String apellido, String pais, String direccion, String telefono,
			String correo) {
		
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", apellido=" + apellido + ", pais=" + pais
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	 
	
}
