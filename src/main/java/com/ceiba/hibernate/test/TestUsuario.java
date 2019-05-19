package com.ceiba.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.ceiba.hibernate.modelo.Usuario;

import java.util.List;

public class TestUsuario {

	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		
		try {
			
			Usuario n = new Usuario("Dante","1093770319","Bibliotecario");
			manager.getTransaction().begin();
			manager.persist(n);
			manager.getTransaction().commit();
			
			List<Usuario> usuarios = (List<Usuario>) manager.createQuery("FROM Usuario").getResultList();
			System.out.println("Los usuarios registrados son : " + usuarios.size());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
