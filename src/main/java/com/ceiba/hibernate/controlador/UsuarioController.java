package com.ceiba.hibernate.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ceiba.hibernate.modelo.Usuario;
import com.ceiba.hibernate.vista.index;

public class UsuarioController {

	private EntityManager manager;

	private EntityManagerFactory emf;
	
	public UsuarioController(EntityManager manager,EntityManagerFactory emf) {
		this.emf = emf;
		this.manager = manager;
	}
	
	private void iniciar() {
		
	}
	
	public List<Usuario> listarUsuarios(){
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) manager.createQuery("FROM Usuario").getResultList();
		return usuarios;
	}
	
	public String registrarUsuario(String nombre,String identificacion,String rol) {
		try {
			this.iniciar();
			emf = Persistence.createEntityManagerFactory("aplicacion");
			manager = emf.createEntityManager();
			List<Usuario> usuarios = listarUsuarios();
			for(Usuario u:usuarios) {
				if(u.getIdentificacion().equalsIgnoreCase(identificacion)) {
					return "Usuario ya registrado";
				}
			}
			
			Usuario n = new Usuario(nombre,identificacion,rol);
			manager.getTransaction().begin();
			manager.persist(n);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ocurrio un problema al momento de registrar al usuario");
		}
		manager.close();
		return "Usuario registrado con exito";
	}
	
	public String modificarUsuario(String identificacion,String nombre,String rol) {
		this.iniciar();
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		Usuario u = manager.find(Usuario.class, identificacion);
		manager.getTransaction().begin();
		u.setNombre(nombre);
		u.setRol(rol);
		manager.getTransaction().commit();
		manager.close();
		return "Cambio en el usuario registrado con exito";
	}
	
	public String buscarUsuario(String identificacion) {
		this.iniciar();
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		List<Usuario> usuarios = listarUsuarios();
		for(Usuario n:usuarios) {
			if(n.getIdentificacion().equalsIgnoreCase(identificacion)) {
				System.out.println(n);
				return n.getNombre();
			}
		}
		return null;
	}
	
	
	

}
