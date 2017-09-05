package com.ragas.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ragas.api.entity.Writer;

@Repository
public class WriterRepositoryImpl implements WriterRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Writer> findAll() {
		TypedQuery<Writer> query = em.createNamedQuery("Writer.findAll", Writer.class);
		return query.getResultList();
	}

	@Override
	public Writer findOne(String id) {
		return em.find(Writer.class, id);
	}

	@Override
	public Writer findByName(String name) {
		TypedQuery<Writer> query = em.createNamedQuery("Writer.findByName", Writer.class);
		query.setParameter("pName", name);

		List<Writer> Writers = query.getResultList();
		if (Writers != null && Writers.size() == 1) {
			return Writers.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Writer create(Writer emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public Writer update(Writer emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Writer emp) {
		em.remove(emp);
	}
}