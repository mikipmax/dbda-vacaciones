package com.distribuida.clases;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class Em {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pujpa");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
