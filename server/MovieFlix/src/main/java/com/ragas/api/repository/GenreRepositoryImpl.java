package com.ragas.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ragas.api.entity.Genre;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Genre> findAll() {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findAll", Genre.class);
		return query.getResultList();
	}

	@Override
	public Genre findOne(String id) {
		return em.find(Genre.class, id);
	}

	@Override
	public Genre findByGenreName(String genreName) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findBygenreName", Genre.class);
		query.setParameter("pgenreName", genreName);

		List<Genre> genres = query.getResultList();
		if (genres != null && genres.size() == 1) {
			return genres.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Genre create(Genre gen) {
		em.persist(gen);
		return gen;
	}

	@Override
	public Genre update(Genre gen) {
		return em.merge(gen);
	}

	@Override
	public void delete(Genre gen) {
		em.remove(gen);
	}
}