package com.ragas.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ragas.api.entity.Actor;

@Repository
public class ActorRepositoryImpl implements ActorRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Actor> findAll() {
		TypedQuery<Actor> query = em.createNamedQuery("Actor.findAll", Actor.class);
		return query.getResultList();
	}

	@Override
	public Actor findOne(String id) {
		return em.find(Actor.class, id);
	}

	@Override
	public Actor findByName(String Name) {
		TypedQuery<Actor> query = em.createNamedQuery("Actor.findByName", Actor.class);
		query.setParameter("pName", Name);

		List<Actor> actors = query.getResultList();
		if (actors != null && actors.size() == 1) {
			return actors.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Actor create(Actor act) {
		em.persist(act);
		return act;
	}

	@Override
	public Actor update(Actor act) {
		return em.merge(act);
	}

	@Override
	public void delete(Actor act) {
		em.remove(act);
	}
}