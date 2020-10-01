package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.clases.Direccion;

@ApplicationScoped
public class DireccionImp implements DireccionI {

	@Inject
	private EntityManager em;

	@Override
	public List<Direccion> listar() {
		List<Direccion> lista = em.createQuery("select a from Direccion a", Direccion.class).getResultList();
		return lista;

	}

	@Override
	public Direccion buscarId(int id) {

		em.getTransaction().begin();
		Direccion dir = em.find(Direccion.class, id);
		em.getTransaction().commit();
		return dir;
	}

	@Override
	public void editar(int id, Direccion direccion) {
		
		direccion.setIdDireccion(id);
		em.getTransaction().begin();
		em.merge(direccion);
		em.getTransaction().commit();
	}

	@Override
	public void crear(Direccion direccion) {
		em.getTransaction().begin();
		em.persist(direccion);
		em.getTransaction().commit();
	}

	@Override
	public void eliminar(int id) {

		em.getTransaction().begin();
		Direccion dir = em.find(Direccion.class, id);
		em.remove(dir);
		em.getTransaction().commit();
	}

}
