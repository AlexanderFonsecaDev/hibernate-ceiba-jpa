package com.ceiba.hibernate.controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PrestamoController {
	
	private EntityManager manager;

	private EntityManagerFactory emf;
	
	public PrestamoController(EntityManager manager,EntityManagerFactory emf) {
		this.emf = emf;
		this.manager = manager;
	}

}
