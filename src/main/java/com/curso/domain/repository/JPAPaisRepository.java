package com.curso.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.curso.domain.Contrie;
@Repository
public class JPAPaisRepository implements PaisRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Contrie> getAllPaisesByRegion(int idRegion) {
		Query query = entityManager.createNamedQuery("Pais.findAll").setParameter("id", idRegion);
		return query.getResultList();
	}

	@Override
	public Contrie findById(String idPais) {
		// TODO Auto-generated method stub
		return entityManager.find(Contrie.class, idPais);
	}

	@Override
	public void remove(String idPais) {
		entityManager.remove(findById(idPais));
		
	}

	@Override
	public void addPais(Contrie nuevoPais) {
		entityManager.persist(nuevoPais);
		
	}

}
