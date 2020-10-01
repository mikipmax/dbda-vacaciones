package com.distribuida.managed;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class ProducerEm {
	@Produces
	public EntityManagerFactory crearEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("pujpa");
	}
	
	@Produces
	public EntityManager crearEntityManager(EntityManagerFactory emf) {
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
