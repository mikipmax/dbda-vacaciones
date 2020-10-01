package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.clases.Singer;

@ApplicationScoped
public class SingerServicioImpl implements SingerServicioI{

	@Inject
	private EntityManager em;
	
	@Override
	public List<Singer> listar() {
		List<Singer> listar = em.createQuery("select c from Singer c", Singer.class).getResultList();
		return listar;
	}

	@Override
	public Singer buscar(int id) {
		Singer singer = null;
		em.getTransaction().begin();
		singer = em.find(Singer.class, id);
		em.getTransaction().commit();
		em.close();
		return singer;
	}

	@Override
	public void crear(Singer cantante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(int idCantante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(int idCantante) {
		// TODO Auto-generated method stub
		
	}

	
	
}
