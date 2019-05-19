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
	
	public UsuarioController() {
		this.emf = Persistence.createEntityManagerFactory("aplicacion");
		this.manager = emf.createEntityManager();
	}
	
	public List<Usuario> listarUsuarios(){
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) manager.createQuery("FROM Usuario").getResultList();
		return usuarios;
	}
	
	public String registrarUsuario(String nombre,String identificacion,String rol) {
		try {
			
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
		Usuario u = manager.find(Usuario.class, identificacion);
		manager.getTransaction().begin();
		u.setNombre(nombre);
		u.setRol(rol);
		manager.getTransaction().commit();
		manager.close();
		return "Cambio en el usuario registrado con exito";
	}
	
	public String borrarUsuario() {
		
	}
	

}
