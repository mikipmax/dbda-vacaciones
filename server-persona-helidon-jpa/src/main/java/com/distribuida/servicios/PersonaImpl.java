package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.clases.Direccion;
import com.distribuida.clases.Persona;
import com.distribuida.rest.DireccionI;

//Componente de negocio que el contenedor
//va a gestionar
@ApplicationScoped
public class PersonaImpl implements PersonaI {

	@Inject
	private EntityManager em;

	private static final String URL = "http://localhost:7002/direcciones";

	ResteasyClient client = new ResteasyClientBuilder().build();
	ResteasyWebTarget target = client.target(URL);
	DireccionI servicio = target.proxy(DireccionI.class);
	Direccion direccion = new Direccion();

//	@Override
//	public List<Persona> listar() {
//		List<Persona> lista = em.createQuery("select a from Persona a", Persona.class).getResultList();
//		return lista;
//	}

	@Override
	public List<Persona> listar() {
		List<Persona> lista = em.createQuery("select a from Persona a", Persona.class).getResultList();
		List<Persona> aux = new ArrayList<>();

		for (Persona p : lista) {

			direccion = servicio.buscarId(p.getTipoDireccion());

			p.setDescripcion(direccion.getDescripcion());
			aux.add(p);

		}

		return aux;

	}

//	@Override
//	public Persona buscarId(int id) {
//		Persona album = null;
//		em.getTransaction().begin();
//		album = em.find(Persona.class, id);
//		em.getTransaction().commit();
//
//		return album;
//	}

	@Override
	public Persona buscarId(int id) {
		Persona album = null;

		em.getTransaction().begin();
		album = em.find(Persona.class, id);

		album.setDescripcion(servicio.buscarId(album.getTipoDireccion()).getDescripcion());
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
