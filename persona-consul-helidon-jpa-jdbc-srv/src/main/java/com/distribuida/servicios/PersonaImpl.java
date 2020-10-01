package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.distribuida.clases.Persona;


//Componente de negocio que el contenedor
//va a gestionar
@ApplicationScoped
@Transactional
public class PersonaImpl implements PersonaI {

	@PersistenceContext(unitName = "pujpa")
	private EntityManager em;

	@Override
	public List<Persona> listar() {
		List<Persona> lista = em.createQuery("select a from Persona a", Persona.class).getResultList();
		return lista;
	}

	@Override
	public Persona buscarId(int id) {
		Persona album = null;
		em.getTransaction().begin();
		album = em.find(Persona.class, id);
		em.getTransaction().commit();

		return album;
	}

	@Override
	public void editar(int id, Persona persona) {

		persona.setId(id);
		em.getTransaction().begin();
		em.merge(persona);
		em.getTransaction().commit();
	}

	@Override
	public void crear(Persona persona) {
		// se necesita transacciones porque no estamos trabajando con EJB

		em.getTransaction().begin();
		em.persist(persona);
		em.getTransaction().commit();

	}

	@Override
	public void eliminar(int id) {
		Persona pers = null;
		em.getTransaction().begin();
		pers = em.find(Persona.class, id);
		em.remove(pers);
		em.getTransaction().commit();
	}
}
