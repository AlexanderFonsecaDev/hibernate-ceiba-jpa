package com.ceiba.hibernate.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "identificacion")
	private String identificacion;
	
	@Column(name = "nombre")
	private String nombre;
		
	@Column(name = "rol")
	private String rol;

	public Usuario() {

	}

	public Usuario(String nombre, String identificacion, String rol) {
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.rol = rol;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", identificacion=" + identificacion + ", rol=" + rol + "]";
	}

}
