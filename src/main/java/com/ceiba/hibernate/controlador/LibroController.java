package com.ceiba.hibernate.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ceiba.hibernate.modelo.Libro;

public class LibroController {

	private EntityManager manager;
	private EntityManagerFactory emf;

	public LibroController() {
		this.emf = Persistence.createEntityManagerFactory("aplicacion");
		this.manager = emf.createEntityManager();
	}

	public List<Libro> listarLibros() {
		@SuppressWarnings("unchecked")
		List<Libro> libros = (List<Libro>) manager.createQuery("FROM Libro").getResultList();
		return libros;
	}

	public String registrarLibro(int isbn, String nombre, int cantidad, boolean palindromo) {
		try {
			boolean existeLibro = false;
			List<Libro> libros = listarLibros();
			for (Libro l : libros) {
				if (l.getIsbn() == isbn) {
					l.setCantidad(l.getCantidad() + 1);
					existeLibro = true;
					return "El libro existe, se agregó al inventario";
				}
			}
			if (!existeLibro) {
				Libro libro = new Libro(isbn, nombre, cantidad, palindromo);
				manager.getTransaction().begin();
				manager.persist(libro);
				manager.getTransaction().commit();
			}
			return "El libro se agregó exitosamente";
		} catch (Exception e) {
			System.out.println("Ocurrio un problema al momento de registrar un libro");
		}
		manager.close();
		return "Libro registrado con exito";
	}

	public String borrarLibro(int isbn, String nombre, int cantidad, boolean palindromo) {
		boolean existenLibros = true;
		List<Libro> libros = listarLibros();
		for (Libro l : libros) {
			if (l.getIsbn() == isbn) {
				l.setCantidad(l.getCantidad() - 1);
				if (l.getCantidad() == 0) {
					existenLibros = false;
				}
				return "El libro existe, se elimino un ejemplar del inventario";
			}
		}
		if (existenLibros) {
			Libro libro = new Libro(isbn, nombre, cantidad, palindromo);
			manager.getTransaction().begin();
			manager.remove(libro);
			manager.getTransaction().commit();
		}
		return "El libro se borró satisfactoriamente";
	}

}
