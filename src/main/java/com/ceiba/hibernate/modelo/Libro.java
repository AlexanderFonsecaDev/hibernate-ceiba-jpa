package com.ceiba.hibernate.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "LIBRO")
public class Libro implements Serializable {

	@Id
	@Column(name = "isbn")
	private int isbn;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "palindromo")
	private boolean palindromo;

	public Libro(int isbn, String nombre, int cantidad, boolean palindromo) {
		super();
		this.isbn = isbn;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.palindromo = palindromo;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isPalindromo() {
		return palindromo;
	}

	public void setPalindromo(boolean palindromo) {
		this.palindromo = palindromo;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", nombre=" + nombre + ", cantidad=" + cantidad + ", palindromo=" + palindromo
				+ "]";
	}

}
